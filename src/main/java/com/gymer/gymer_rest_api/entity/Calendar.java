package com.gymer.gymer_rest_api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Calendar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private CalendarType calendarType;

	public Calendar(CalendarType calendarType) {
		this.calendarType = calendarType;
	}
}
