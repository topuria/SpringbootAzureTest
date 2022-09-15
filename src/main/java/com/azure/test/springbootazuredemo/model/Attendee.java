package com.azure.test.springbootazuredemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Attendee {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String company;
    private String email;
    @Enumerated(EnumType.ORDINAL)
    private RegistrationType registrationType;
    @Enumerated(EnumType.ORDINAL)
    private Payment payment;
    @Enumerated(EnumType.ORDINAL)
    private Referral referral;
    private String registrationOther;

}
