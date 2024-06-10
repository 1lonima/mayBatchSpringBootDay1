package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.EmployeeDTO;
import com.exceptions.NegativeIdException;
import com.service.EmployeeService;

@RestController
@RequestMapping("/version3")
public class EmployeeRestController3 {
	
	@Autowired
	EmployeeService employeeService;
	
	
	//fetch all records
		@GetMapping("/employees")  ////localhost:666/version2/employees
		public ResponseEntity<List<EmployeeDTO>> fetchAllRecords() {
			
		List<EmployeeDTO>	employeeDtoList=employeeService.findAllEmployees();			
		   
			return new ResponseEntity<>(employeeDtoList,HttpStatus.OK);
		}
		
		
		//fetch a particular record on basis of id
				@GetMapping("/emp/{employeeId}") //localhost:666/v1/emp/7
				public ResponseEntity<?> fetchRecordOfEmployee(@PathVariable int employeeId) {
				EmployeeDTO	employeeDto=employeeService.fetchRecord(employeeId);  
				
				if(employeeDto!=null) {
					return new ResponseEntity<>(employeeDto,HttpStatus.OK);	
				}
				
				else {
					return new ResponseEntity<>("Employee doesn't exist",HttpStatus.OK);	
				}
				   
					
				}
				
				
				//localhost:666/employees
				
				//registering a user
				@PostMapping("/employees")
				public ResponseEntity<String> registerEmployee(@RequestBody EmployeeDTO employeeDTO) {
					
					        
					employeeService.registerEmp(employeeDTO);
					
					return new ResponseEntity<>("registered successfully",HttpStatus.CREATED);
					
					
					
				}
				
				
				@PutMapping("/employees")
				public String updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
					
					        
					employeeService.registerEmp(employeeDTO);//here it will work as update because we are providind employeeID
					
					
					return "updated successfully";
				}
				
				
				@DeleteMapping("/employees/{employeeId}") //localhost:666/version3/employees/2
				public String deleteRecordOfEmployee(@PathVariable int employeeId) {
					if(employeeId<=0) {
						
						throw new NegativeIdException("ID cannot be Negative");
					}
					try {
				employeeService.deleteEmp(employeeId);  
				   
					return "deleted successfully";
					}
					catch(EmptyResultDataAccessException ex) { //reminder:if we do not know the type of exception just write Exception
						return "This ID can't be deleted as it does not exist";
					}
				}
				
					
		
}