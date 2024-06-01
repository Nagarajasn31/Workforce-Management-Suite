package com.employee.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.domain.Employee;
import com.employee.exception.ResourceNotFoundException;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
	 return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
	return	employeeRepository.findAll();
	
	}

	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee", "Id", id));
	}

	public Employee updateEmployee(Employee employee, int id) {
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setName(employee.getName());
		existingEmployee.setDesignation(employee.getDesignation());
		existingEmployee.setSalary(employee.getSalary());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	public String deleteEmployee(int id) {
		employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
		return "Employee Dleted Successfully";
	}
}
