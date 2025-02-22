package com.gymer.gymer_rest_api.entity.implementation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gymer.gymer_rest_api.entity.BaseEntityBehaviour;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Slot implements BaseEntityBehaviour<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Time startTime;

    @NotNull
    private Time endTime;

    @NotNull
    private Date date;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @NotNull
    private boolean occupied;

    @JsonIgnore
    @Column(columnDefinition = "boolean default true")
    private boolean active = true;

}
