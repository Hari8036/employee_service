package com.edusol.employee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edusol.employee.model.Employee;
import com.edusol.employee.repository.EmployeeRepository;
import com.google.gson.JsonObject;

@Service
public class EmployeeService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeRepository employeeRepository;

	public Object getEmployee() {
		return employeeRepository.findAll();
	}

	public Object addEmployee(Employee employee) {
		logger.info(employee.toString());
		employeeRepository.save(employee);
		logger.info("Employee added succesfully");
		return new ResponseEntity<>("employee Added Sucessfully", HttpStatus.CREATED);
	}

	public Object getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}

	public Object getEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}

	public Object getEmployeeByDepartment(String department) {
		return employeeRepository.findBydepartment(department);

	}

	public Object updateEmployee(Employee employee) {
		JsonObject response = new JsonObject();

		System.out.println("Request employee:" + employee);
		int id = employee.getId();
		try {

			Employee emp = employeeRepository.getOne(id);
			System.out.println("Request employee:" + emp);

			System.out.println("old employee:" + emp);
			emp.setName(employee.getName());
			System.out.println("New employee:" + emp);
			employeeRepository.save(emp);
		} catch (Exception e) {
			logger.info(e.getMessage());

			response.addProperty("statusCode", 404);
			response.addProperty("statusMessage", e.getMessage());

			return new ResponseEntity<>(response.toString(), HttpStatus.NOT_FOUND);

		}
		logger.info("Employee updated Successfully");
		return new ResponseEntity<>("Employee updated succesfully", HttpStatus.OK);

	}

	public Object deleteEmployee(int id) {
		try {
			employeeRepository.deleteById(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

		}
		logger.info("Employee deleted Successfully");
		return new ResponseEntity<>("Employee deleted succesfully", HttpStatus.OK);

	}
}
