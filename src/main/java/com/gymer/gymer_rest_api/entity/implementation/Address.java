package com.gymer.gymer_rest_api.entity.implementation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gymer.gymer_rest_api.entity.BaseEntityBehaviour;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address implements BaseEntityBehaviour<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String city;
    private String street;
    private String localNumber;
    private String zipCode;

    @JsonIgnore
    private boolean active = true;

}
