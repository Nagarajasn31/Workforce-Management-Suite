package com.employee.service;
import com.employee.domain.Employee;
import java.util.List;


public interface EmployeeService {

	 Employee saveEmployee(Employee employee);
	 List<Employee> getAllEmployees();
	 Employee getEmployeeById(int id);
	 Employee updateEmployee(Employee employee, int id);
	 public String deleteEmployee(int id);
}
