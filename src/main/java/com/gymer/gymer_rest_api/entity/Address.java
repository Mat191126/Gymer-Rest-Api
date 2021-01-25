package com.gymer.gymer_rest_api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private String street;
    private String localNumber;
    private String zipCode;

    public Address(String city, String street, String localNumber, String zipcode) {
        this.city = city;
        this.street = street;
        this.localNumber = localNumber;
        this.zipCode = zipcode;
    }

}
