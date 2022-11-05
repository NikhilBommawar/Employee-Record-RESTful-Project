package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

														// pojo    // id data type
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

// JPQL - Java Persistence Query Language
// User defined query using HQL
	
	@Query("select employee from Employee employee where empname=?1")
	public List<Employee> findbyname(String name);

}
