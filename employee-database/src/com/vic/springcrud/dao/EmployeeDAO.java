package com.vic.springcrud.dao;

import java.util.List;

import com.vic.springcrud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);
	
}
