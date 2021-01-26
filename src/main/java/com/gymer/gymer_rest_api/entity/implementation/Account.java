package com.gymer.gymer_rest_api.entity.implementation;

import com.gymer.gymer_rest_api.entity.IdObtainable;
import com.gymer.gymer_rest_api.entity.enumerated.AccountType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Account implements IdObtainable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private String phoneNumber;
    private Integer age;
    private Integer height;
    private Integer weight;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Calendar calendar;

}
