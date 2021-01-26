package com.gymer.gymer_rest_api.entity.implementation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gymer.gymer_rest_api.entity.BaseEntityBehaviour;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Gym implements BaseEntityBehaviour<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Time openTime;

    @NotNull
    private Time closeTime;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Calendar calendar;

    @OneToMany
    private List<Account> employees;

    @JsonIgnore
    private boolean active = true;

}
