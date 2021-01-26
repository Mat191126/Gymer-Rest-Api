package com.gymer.gymer_rest_api.entity.implementation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gymer.gymer_rest_api.entity.BaseEntityBehaviour;
import com.gymer.gymer_rest_api.entity.enumerated.CalendarType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Calendar implements BaseEntityBehaviour<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Slot> slots;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CalendarType calendarType;

    @JsonIgnore
    private boolean active = true;

}
