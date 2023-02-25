package com.ta.spring.code.TA_Spring_Framework.pojo.files;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {

	private int id;
	private String name;
	private LocalDate dob;

}