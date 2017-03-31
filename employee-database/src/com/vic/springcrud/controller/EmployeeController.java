package com.vic.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vic.springcrud.entity.Employee;
import com.vic.springcrud.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get the employees from service
		List<Employee> theEmployees = employeeService.getEmployees();
		
		// add employees to model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveCustomer(@ModelAttribute("employee") Employee theEmployee) {
		
		employeeService.saveEmployee(theEmployee);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		// get employee from service
		Employee theEmployee = employeeService.getEmployee(theId);
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
		
		employeeService.deleteEmployee(theId);
		
		return "redirect:/employee/list";
	}
}
