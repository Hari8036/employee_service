package com.edusol.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusol.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee>findByName(String name);

	List<Employee>findBydepartment(String department);

}
