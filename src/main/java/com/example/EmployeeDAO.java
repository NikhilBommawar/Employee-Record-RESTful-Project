package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeeDAO {

	//creation of reference 
	@Autowired
	EmployeeRepository repo;
	
	
	//insertion 
	public Employee insert(Employee e) {
		return repo.save(e);
	}
	
	// insert (more than one entry) as a list
	
	public List<Employee> insertall(List<Employee> e){
		return repo.saveAll(e);
	}
	
	
	//retrieval 
	
	public List<Employee> getall(){
		return repo.findAll();
	}
	
	// get by id
	
	public Optional<Employee> getbyid(int id){
		return repo.findById(id);
	}
	
	
	// update
	public Employee EditUser(Employee e) {
	 Employee e2=repo.findById(e.getEmpno()).orElse(null);
	 e2.setEmpemail(e.getEmpemail());
	 e2.setEmpname(e.getEmpname());
	 e2.setAge(e.getAge());
	 return repo.save(e2);
	}
	
	// update by name

	/*
	 * 1. Fetching record from the table
	 * 2. we set the value (updating)
	 * 3. we save the value to complete the updation
	 * */
	
	public Employee updatebyname(Employee e) {
		Employee ee=repo.findById(e.getEmpno()).orElse(null);
		ee.setEmpname(e.getEmpname());
	    return repo.save(ee);
	
	}
	
	// Delete
	
	public String DeletebyID(Employee e) {
		repo.deleteById(e.getEmpno());
		return "Deleted Emplyee with EmpNo "+e.getEmpno();
		
	}
    
	// delete by id
	public String delete(int id) {
		repo.deleteById(id);
		// repo.deleteAll();  - deleting all entries	
		return "Deleted id value "+id;
	}
	
	// find by name - user defined repository method using HQL
	public List<Employee> findbyname(String name){
		return repo.findbyname(name);
	}
   
}
