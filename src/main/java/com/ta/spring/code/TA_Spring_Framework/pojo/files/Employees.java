package com.ta.spring.code.TA_Spring_Framework.pojo.files;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class Employees {
	
	private @Getter @Setter int empId;
	private @Getter @Setter String empName;
	private @Getter @Setter String empRole;	

}