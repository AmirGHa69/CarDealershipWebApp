package org.example.cardealershipwebapp.CustomerManagementSubDomain.BusinessLayer;


import org.example.cardealershipwebapp.CustomerManagementSubDomain.DataAccessLayer.Customer;
import org.example.cardealershipwebapp.CustomerManagementSubDomain.DataAccessLayer.CustomerRepository;
import org.example.cardealershipwebapp.CustomerManagementSubDomain.DataMapperLayer.CustomerRequestMapper;
import org.example.cardealershipwebapp.CustomerManagementSubDomain.DataMapperLayer.CustomerResponseMapper;
import org.example.cardealershipwebapp.CustomerManagementSubDomain.PresentationLayer.CustomerRequestModel;
import org.example.cardealershipwebapp.CustomerManagementSubDomain.PresentationLayer.CustomerResponseModel;
import org.example.cardealershipwebapp.Utils.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerResponseMapper customerResponseMapper;
    private final CustomerRequestMapper customerRequestMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerResponseMapper customerResponseMapper,
                               CustomerRequestMapper customerRequestMapper) {
        this.customerRepository = customerRepository;
        this.customerResponseMapper = customerResponseMapper;
        this.customerRequestMapper = customerRequestMapper;
    }

    @Override
    public List<CustomerResponseModel> getCustomers() {
        List<Customer> customers = this.customerRepository.findAll();

//        List<CustomerResponseModel> customerResponseModels =
//                fromEntityListToModelList(customers);

        return this.customerResponseMapper.entityListToResponseModelList(customers);
    }

    @Override
    public CustomerResponseModel getCustomerbyCustomerId(String customer_id) {
        Customer customer = this.customerRepository.findCustomerByCustomerIdentifier(customer_id);
        CustomerResponseModel result = null;
        if (customer == null) {
            throw new NotFoundException("Customer with " + customer_id + " not found.");
        } else {
            result = this.customerResponseMapper.entityToResponseModel(customer);
        }
        return result;
    }

    @Override
    public String addCustomer(CustomerRequestModel newCustomerData) {
        String message = "";
        String pw1 = newCustomerData.getPassword1();
        String pw2 = newCustomerData.getPassword2();
        if (pw1 == null) {
            pw1 = "";
        }
        if (pw2 == null) {
            pw2 = "";
        }
        if (!pw1.equals(pw2)) {
            message = "Entered passwords do not match!";
        } else {
            String customerId = newCustomerData.getCustomerIdentifier();
            Customer foundCustomer = this.customerRepository.findCustomerByCustomerIdentifier(customerId);
            if (foundCustomer != null) {
                message = "Customer with customer id: " + customerId + " is already in repository." +
                        "Choose another Customer Identifier.";
            } else {
                Customer customer = this.customerRequestMapper.requestModelToEntity(newCustomerData);
                customer.setCustomerIdentifier(newCustomerData.getCustomerIdentifier());
                customer.setPassword(newCustomerData.getPassword1());
                Customer savedCustomer = this.customerRepository.save(customer);
                if (savedCustomer != null)
                    message = "Customer saved successfully.";
                else
                    message = "Could not save new customer into repository.";
            }
        }
        return message;
    }

    @Override
    public String updateCustomer(String customerId, CustomerRequestModel newCustomerData) {
        String message = "";
        Customer foundCustomer = this.customerRepository.findCustomerByCustomerIdentifier(customerId);
        if (foundCustomer == null) {
            message = "Customer with id: " + customerId + " not found in repository.";
        } else {
            String pw1 = newCustomerData.getPassword1();
            String pw2 = newCustomerData.getPassword2();
            if (pw1 == null) {
                pw1 = "";
            }
            if (pw2 == null) {
                pw2 = "";
            }
            if (pw1.equals(pw2)) {
                Customer customer = this.customerRequestMapper.requestModelToEntity(newCustomerData);
                customer.setPassword(newCustomerData.getPassword1());
                customer.setCustomerIdentifier(customerId); // important
                customer.setId(foundCustomer.getId());  // important
                Customer savedCustomer = this.customerRepository.save(customer);
                if (savedCustomer != null)
                    message = "Customer updated successfully.";
                else
                    message = "Could not save new customer into repository.";

            } else
                message = "Entered passwords do not match!";
        }
        return message;
    }

    @Override

    public String deleteCustomerbyCustomerId(String customerId) {
        String message = "";
        Customer foundCustomer = this.customerRepository.findCustomerByCustomerIdentifier(customerId);
        if (foundCustomer == null) {
            message = "Customer with id: " + customerId + " not found in repository.";
        } else {

            this.customerRepository.delete(foundCustomer);
            message = "Customer with id: " + customerId + " deleted successfully.";
        }
        return message;
    }

    // Helper methods
//    public CustomerResponseModel fromEntityToModel(Customer customer) {
//        CustomerResponseModel customerResponseModel =
//                new CustomerResponseModel();
//        customerResponseModel.setFirstName(customer.getFirstName());
//        customerResponseModel.setLastName(customer.getLastName());
//
//        return customerResponseModel;
//    }
//
//    public List<CustomerResponseModel> fromEntityListToModelList(
//            List<Customer> customers) {
//
//        List<CustomerResponseModel> customerResponseModels =
//                new ArrayList<>();
//        for (Customer c : customers) {
//            customerResponseModels.add(fromEntityToModel(c));
//        }
//
//
//        return customerResponseModels;
//    }

}


