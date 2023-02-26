package com.ta.spring.code.TA_Spring_Framework.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ta.spring.code.TA_Spring_Framework.pojo.files.Employees;
import com.ta.spring.code.TA_Spring_Framework.pojo.files.EmployeesV2;
import com.ta.spring.code.TA_Spring_Framework.pojo.files.EmployeesV2.Address;

@Service
public class EmployeesService {	
	
	public static List<Employees> employees = new ArrayList<Employees>();
	public static List<EmployeesV2> employeesv2 = new ArrayList<EmployeesV2>();
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

	public Employees addEmployee(Employees employee) {
		Employees newEmployee = Employees.builder().empId(++id).empName(employee.getEmpName()).empRole(employee.getEmpRole()).build();
		employees.add(newEmployee);	
		return newEmployee;
	}

	public Employees updateEmployee(Employees employee) {
		//System.out.println(employees.stream().filter(emp -> emp.getEmpId() == employee.getEmpId()).findFirst().t);
		Employees updateEmployee = null;
		for (Employees emp : employees) {
			if(emp.getEmpId() == employee.getEmpId()) {			
				//updateEmployee = Employees.builder().empId(emp.getEmpId()).empName(employee.getEmpName()).empRole(emp.getEmpRole()).build();
				updateEmployee = emp;
				updateEmployee.setEmpId(emp.getEmpId());
				updateEmployee.setEmpName(employee.getEmpName());
				updateEmployee.setEmpRole(emp.getEmpRole());
				break;
			}
		}
		return updateEmployee;		
	}

	public void deleteEmployees(int id) {
		employees.removeIf(emp -> emp.getEmpId() == id);		
	}

	public List<EmployeesV2> getAllEmployeesV2() {
		Address address = EmployeesV2.Address.builder().street("75, New Street").city("Chennai").country("India").postCode("600130").build();
		employeesv2.add(EmployeesV2.builder().empId(++id).empName("King").empRole("Developer").address(address).build());
		return employeesv2;		
	}	

}