package org.example.cardealershipwebapp.CustomerManagementSubDomain.PresentationLayer;

import lombok.Data;

@Data
public class CustomerRequestModel {
    private String customerIdentifier; //public identifier
    private String lastName;
    private String firstName;
    private String emailAddress;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String province;
    private String username;
    private String password1;
    private String password2;
    private String type;
    private String number;
}
