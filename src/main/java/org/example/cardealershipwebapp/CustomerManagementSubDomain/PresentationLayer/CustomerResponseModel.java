package org.example.cardealershipwebapp.CustomerManagementSubDomain.PresentationLayer;

import lombok.Data;

@Data
public class CustomerResponseModel {
    private String customerIdentifier; //public identifier
    private String lastName;
    private String firstName;
    private String emailAddress;

    private String streetAddress;
    private String postalCode;
    private String city;
    private String province;

    private String phoneType;
    private String phoneNumber;


}
