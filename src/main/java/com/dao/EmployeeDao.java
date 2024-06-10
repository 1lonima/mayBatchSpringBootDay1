package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.EmployeeEntity;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity,Integer>{

	
	
	Optional<EmployeeEntity> findByEmailIdAndPassword(String emailId, String password);

	

	   // List<EmployeeEntity> findAll();
	
	
	
}
