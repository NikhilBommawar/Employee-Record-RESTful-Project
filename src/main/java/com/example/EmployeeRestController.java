package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRestController {

	@Autowired
	EmployeeDAO dao; 
	
	@PostMapping("insert")
	public Employee insertrecord(@RequestBody Employee e) {
	  return dao.insert(e);	
	}
	
	@DeleteMapping("delete")
	public String deleterecord(@RequestBody Employee e) {
	  dao.DeletebyID(e);
	  return "Deleted the record "+e.getEmpname();
	}
	
	@GetMapping("readall")
	public List<Employee> getall(){
		return dao.getall();
	}
	
	
	@DeleteMapping("deletebyid/{id}")
	public String deletebyid(@PathVariable Integer id) {
		dao.delete(id);
		return "Deleted successfully "+id;
	}

// find by name- user defined method (HQL)

	@GetMapping("findbyname/{name}")
	public List<Employee> findbyname(@PathVariable String name){
		
	return dao.findbyname(name);
	}
	
       // user defined exception- Exception Handling
	@GetMapping("/findbyid/{id}")
	public Optional<Employee> getbyid(@PathVariable int id) throws ResourceNotFoundException {
		if(dao.getbyid(id).isEmpty()) {
			throw new ResourceNotFoundException("id not found");  // throwing exception if id not found
		
	}
	else {
		return dao.getbyid(id);
	}


}
}
