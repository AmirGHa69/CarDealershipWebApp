package org.example.cardealershipwebapp.CustomerManagementSubDomain.DataMapperLayer;

import org.example.cardealershipwebapp.CustomerManagementSubDomain.DataAccessLayer.Customer;
import org.example.cardealershipwebapp.CustomerManagementSubDomain.PresentationLayer.CustomerRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "id", ignore = true)
    Customer requestModelToEntity(CustomerRequestModel customerRequestModel);

    List<Customer> requestModelListToEntityList(List<CustomerRequestModel> customerRequestModel);

}
