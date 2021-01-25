package com.gymer.gymer_rest_api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Integer age;
    private Integer height;
    private Integer weight;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    public Account(String firstName, String lastName, String email,
                   String password, String phoneNumber, Integer age,
                   Integer height, Integer weight, AccountType accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.accountType = accountType;
    }
}
