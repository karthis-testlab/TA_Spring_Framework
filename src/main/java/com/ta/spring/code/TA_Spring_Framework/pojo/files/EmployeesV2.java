package com.ta.spring.code.TA_Spring_Framework.pojo.files;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class EmployeesV2 {
	
	private @Getter @Setter int empId;
	private @Getter @Setter String empName;
	private @Getter @Setter String empRole;	
	private @Getter @Setter Address address;	
	
	@Builder
	public static class Address {
		
		private @Getter @Setter String street;
		private @Getter @Setter String city;
		private @Getter @Setter String country;
		private @Getter @Setter String postCode;
		
	}

}