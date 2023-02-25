package com.ta.spring.code.TA_Spring_Framework.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ta.spring.code.TA_Spring_Framework.pojo.files.Employees;

@Service
public class EmployeeService {	
	
	public static List<Employees> employees = new ArrayList<Employees>();
	public static int id = 0;
	
	static {
		employees.add(Employees.builder().empId(++id).empName("Karthikeyan").empRole("Senior QA").build());
		employees.add(Employees.builder().empId(++id).empName("Gaj").empRole("Senior QA Manager").build());
		employees.add(Employees.builder().empId(++id).empName("Sabitha").empRole("QA Lead").build());
		employees.add(Employees.builder().empId(++id).empName("Hare").empRole("QA Manager").build());
	}
	
	public List<Employees> getAllEmployees(){		
		return employees;
	}
	
	public Employees getEmployee(int id) {
		return employees.stream().filter(emp -> emp.getEmpId() == id).findFirst().orElse(null);
	}
	
	

}