package com.dto;

public class EmployeeDTO {
	int employeeId;
	String employeeName;
	int Salary;
	String emailId;
	String Password;
	
	
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmployeeDTO(int employeeId, String employeeName, int salary, String emailId, String password) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		Salary = salary;
		this.emailId = emailId;
		Password = password;
	}


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


	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", employeeName=" + employeeName + ", Salary=" + Salary
				+ ", emailId=" + emailId + ", Password=" + Password + "]";
	}
	
	
	
	
	
	
}
