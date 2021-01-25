package com.gymer.gymer_rest_api.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Gym {

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

    public Gym(String name,
               String description,
               Time openTime,
               Time closeTime,
               Address address,
               Calendar calendar,
               List<Account> employees) {
        this.name = name;
        this.description = description;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.address = address;
        this.calendar = calendar;
        this.employees = employees;
    }

}
