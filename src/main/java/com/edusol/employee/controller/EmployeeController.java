package com.edusol.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.employee.model.Employee;
import com.edusol.employee.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/get-employee")
	public Object getEmployee() {
		@SuppressWarnings("unchecked")
		List<Employee> employee = (List<Employee>) employeeService.getEmployee();
		logger.info(employee.toString());
		return employee;
	}

	@PostMapping("/add-employee")
	public Object addEmployee(@RequestBody Employee employee) {
		logger.info(employee.toString());
		return employeeService.addEmployee(employee);

	}

	@GetMapping("/get-employee-id")
	public Object getEmployeeById(@RequestParam int id) {
		Object employee = employeeService.getEmployeeById(id);
		logger.info(employee.toString());
		return employee;
	}

	@GetMapping("/get-employee-name")
	public Object getEmployeeByName(@RequestParam String name) {
		@SuppressWarnings("unchecked")
		List<Employee> employee = (List<Employee>) employeeService.getEmployeeByName(name);
		logger.info(employee.toString());
		return employee;

	}

	@GetMapping("/get-employee-department")
	public Object getEmployeeByDepartment(@RequestParam String department) {
		@SuppressWarnings("unchecked")
		List<Employee> employee = (List<Employee>) employeeService.getEmployeeByDepartment(department);
		logger.info(employee.toString());
		return employee;
	}

	@PutMapping("/update-employee")
	public Object updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);

	}

	@DeleteMapping("/delete-employee")
	public Object deleteEmployee(@RequestParam int id) {
		return employeeService.deleteEmployee(id);
	}
}
