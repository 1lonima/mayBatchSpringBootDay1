package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name= "emp_tbl")
public class EmployeeEntity {
int employeeId;  // we need the employee ID to be the primary key(PK) as well as auto generated
String employeeName;
int Salary;
String emailId;
String Password;


@Id           //This will make it a primary key. // this annotation is put where the setter and getter is done
@GeneratedValue(strategy=GenerationType.AUTO)
public int getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}

public String getEmployeeName() {
	return employeeName;
}

public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}

public int getSalary() {
	return Salary;
}

public void setSalary(int salary) {
	Salary = salary;
}

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}

public EmployeeEntity(int employeeId, String employeeName, int salary, String emailId, String password) {
	super();
	this.employeeId = employeeId;
	this.employeeName = employeeName;
	Salary = salary;
	this.emailId = emailId;
	Password = password;
}

public EmployeeEntity() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "EmployeeEntity [employeeId=" + employeeId + ", employeeName=" + employeeName + ", Salary=" + Salary
			+ ", emailId=" + emailId + ", Password=" + Password + "]";
}




}
