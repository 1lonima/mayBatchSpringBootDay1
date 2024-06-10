package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeDao;
import com.dto.EmployeeDTO;
import com.entity.EmployeeEntity;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;


	@Override
	public void registerEmp(EmployeeDTO employeeDTO) {
		
		EmployeeEntity employeeEntity=new EmployeeEntity();
		
		//copy employeeDTO to employeeEntity
		BeanUtils.copyProperties(employeeDTO, employeeEntity);
		employeeDao.save(employeeEntity); //employeeEntity object will be saved in table as a record
		
	}


	@Override
	public EmployeeDTO authenticate(String emailId, String password) {
		Optional<EmployeeEntity> optional=employeeDao.findByEmailIdAndPassword(emailId,password);
			
		EmployeeDTO  employeeDTO=null;
		
		if(optional.isPresent()) {
			//valid
			EmployeeEntity employeeEntity=optional.get();
			
			employeeDTO=new EmployeeDTO();
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			
			return employeeDTO;   //not null
		} else {
			//for false condition (if record not found)
			return employeeDTO;  //null
		}
			
			
	}
//delete operations

	@Override
	public List<EmployeeDTO> findAllEmployees() {
		List<EmployeeEntity> employeeEntity=employeeDao.findAll();
		
		List<EmployeeDTO>  employeeDtoList=new ArrayList<>();     //blank arrayList
		
		//if(employeeEntity.isEmpty()) {
			//Returns true if this list contains no elements.<----isEmpty()
			if(employeeEntity.size()>0) {
			           for(EmployeeEntity   tempa:employeeEntity) {
			        	                    //1st          //3
			        	   EmployeeDTO employeeDTO=new EmployeeDTO();
			        	   
			        	   BeanUtils.copyProperties(tempa,employeeDTO );
			        	                             //1st    //copied in employeeDTO
			        	                      //2nd   //3rd
			        	   
			        	   employeeDtoList.add(employeeDTO); //in first iteration, first object has been added in blank arrayList
			           }
			      }
		
		
		
		
		
		return employeeDtoList; //employeeDtoList<---it is collection of records in the form of objects
	}

//delete operations
	
	@Override
	public void deleteEmp(int employeeId) {
		employeeDao.deleteById(employeeId);
		
	}

			
//fetch all the data on edit form(updateEmployee)
	@Override
	public EmployeeDTO fetchRecord(int employeeId) {
		Optional<EmployeeEntity> optional=employeeDao.findById(employeeId);
		EmployeeDTO employeeDTO=null;
		
		
		if(optional.isPresent()) {
		EmployeeEntity employeeEntity=optional.get();
		employeeDTO=new EmployeeDTO();
		BeanUtils.copyProperties(employeeEntity,employeeDTO);
				
				return employeeDTO;
		}else {
			return employeeDTO;
		}
	}


	@Override
	public void updateEmployee(EmployeeDTO employeeDTO) {
EmployeeEntity employeeEntity=new EmployeeEntity();
		
		BeanUtils.copyProperties(employeeDTO,employeeEntity);
		employeeDao.save(employeeEntity);
		
	}


			
}
