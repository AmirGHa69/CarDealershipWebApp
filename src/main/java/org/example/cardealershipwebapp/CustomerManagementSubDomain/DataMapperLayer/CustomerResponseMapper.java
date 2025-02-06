package org.example.cardealershipwebapp.CustomerManagementSubDomain.DataMapperLayer;

import org.example.cardealershipwebapp.CustomerManagementSubDomain.DataAccessLayer.Customer;
import org.example.cardealershipwebapp.CustomerManagementSubDomain.PresentationLayer.CustomerResponseModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerResponseMapper {
    CustomerResponseModel entityToResponseModel(Customer customer);

    List<CustomerResponseModel> entityListToResponseModelList(List<Customer> customers);
}
