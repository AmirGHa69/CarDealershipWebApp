package org.example.cardealershipwebapp.CustomerManagementSubDomain.DataAccessLayer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "customers")
@Builder
@Data
//Since you're using Lombok with @Builder, the @Builder annotation removes the default constructor. You need to explicitly add a no-args constructor.
@NoArgsConstructor  // Generates a no-arg constructor
@AllArgsConstructor // Generates a constructor with all fields
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //private identifier

    private String customerIdentifier; //public identifier
    private String lastName;
    private String firstName;
    private String emailAddress;

    @Embedded
    private Address address;
    @Embedded
    private PhoneNumber phoneNumber;

    private String username;
    private String password;

}
