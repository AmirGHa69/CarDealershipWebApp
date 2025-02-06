package org.example.cardealershipwebapp.CustomerManagementSubDomain.PresentationLayer;


import org.example.cardealershipwebapp.CustomerManagementSubDomain.BusinessLayer.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerServiceImpl customerService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {

        this.customerService = customerService;
    }

    @GetMapping()
    public List<CustomerResponseModel> getCustomers() {

        return this.customerService.getCustomers();
    }

    @GetMapping("/{customer_id}")
    public CustomerResponseModel getCustomerbyCustomerId(@PathVariable String customer_id) {
        return this.customerService.getCustomerbyCustomerId(customer_id);
    }

    @PostMapping()
    public String addCustomer(@RequestBody CustomerRequestModel newCustomerData) {
        return this.customerService.addCustomer(newCustomerData);
    }

    @PutMapping("/{customer_id}")
    public String updateCustomer(@PathVariable String customer_id,
                                 @RequestBody CustomerRequestModel newCustomerData) {
        return this.customerService.updateCustomer(customer_id, newCustomerData);
    }

    @DeleteMapping("/{customer_id}")
    public String deleteCustomerbyCustomerId(@PathVariable String customer_id) {
        return this.customerService.deleteCustomerbyCustomerId(customer_id);
    }
}

