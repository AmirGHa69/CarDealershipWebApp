package org.example.cardealershipwebapp.CustomerManagementSubDomain.DataMapperLayer;

import org.example.cardealershipwebapp.CustomerManagementSubDomain.DataAccessLayer.Customer;
import org.example.cardealershipwebapp.CustomerManagementSubDomain.PresentationLayer.CustomerResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CustomerResponseMapper {
    @Mappings(
            {
                    @Mapping(target = "customerIdentifier", source = "customerIdentifier"),
                    @Mapping(target = "lastName", source = "lastName"),
                    @Mapping(target = "firstName", source = "firstName"),
                    @Mapping(target = "emailAddress", source = "emailAddress"),
                    @Mapping(target = "streetAddress", source = "address.streetAddress"),
                    @Mapping(target = "postalCode", source = "address.postalCode"),
                    @Mapping(target = "city", source = "address.city"),
                    @Mapping(target = "province", source = "address.province"),
                    @Mapping(target = "phoneType", source = "phoneNumber.type"),
                    @Mapping(target = "phoneNumber", source = "phoneNumber.number")
            }
    )
    CustomerResponseModel entityToResponseModel(Customer customer);

    List<CustomerResponseModel> entityListToResponseModelList(List<Customer> customers);
}
