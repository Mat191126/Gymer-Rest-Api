package com.gymer.gymer_rest_api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@NoArgsConstructor
@Data
@Entity
public class Slot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Time startTime;
	private Time endTime;

	@ManyToOne
	private Address address;
	private boolean occupied;
	private Callendar calendar;

	public Slot(Time startTime, Time endTime, Address address, boolean occupied, Callendar calendar) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.address = address;
		this.occupied = occupied;
		this.calendar = calendar;
	}
}
