package com.gymer.gymer_rest_api.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Time startTime;

    @NotNull
    private Time endTime;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @NotNull
    private boolean occupied;

    @OneToOne(cascade = CascadeType.ALL)
    private Calendar calendar;

}
