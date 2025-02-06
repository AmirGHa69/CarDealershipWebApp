package org.example.cardealershipwebapp.CustomerManagementSubDomain.BusinessLayer;

import org.example.cardealershipwebapp.CustomerManagementSubDomain.PresentationLayer.CustomerRequestModel;
import org.example.cardealershipwebapp.CustomerManagementSubDomain.PresentationLayer.CustomerResponseModel;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseModel> getCustomers();

    CustomerResponseModel getCustomerbyCustomerId(String customer_id);

    String addCustomer(CustomerRequestModel newCustomerData);

    String updateCustomer(String customerId, CustomerRequestModel newCustomerData);

    String deleteCustomerbyCustomerId(String customerId);
}
