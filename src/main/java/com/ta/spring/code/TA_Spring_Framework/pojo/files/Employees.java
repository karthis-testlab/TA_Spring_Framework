package com.ta.spring.code.TA_Spring_Framework.pojo.files;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class Employees {
	
	@NotNull(message = "empId should not be null")
	@JsonProperty("employee_id")
	private @Getter @Setter int empId;
	
	@NotNull(message = "empName is a mandatory field")
	@Size(min = 2, max = 20, message = "empName should between 2 to 20 charaters")
	@JsonProperty("employee_name")
	private @Getter @Setter String empName;
	
	@Size(min = 5, max = 50, message = "empRole should between 5 to 50 charaters")
	@JsonProperty("employee_role")
	private @Getter @Setter String empRole;

}