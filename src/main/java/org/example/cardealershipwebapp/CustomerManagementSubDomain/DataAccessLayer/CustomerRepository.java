package org.example.cardealershipwebapp.CustomerManagementSubDomain.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findCustomerByCustomerIdentifier(String customerIdentifier);

    Customer findCustomerByEmailAddress(String emailAddress);
}