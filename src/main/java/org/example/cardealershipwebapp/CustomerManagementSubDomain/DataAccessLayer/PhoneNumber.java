package org.example.cardealershipwebapp.CustomerManagementSubDomain.DataAccessLayer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PhoneNumber {
    @Enumerated(EnumType.STRING)
    @Column(name = "phone_type")
    private PhoneType type;
    @Column(name = "phone_number")
    private String number;
}
