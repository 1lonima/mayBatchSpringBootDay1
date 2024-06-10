<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>congratulation page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

<div class="container">
  <h2>Congratulations You have received all records!!!</h2>
            
  <table class="table table-hover">
    <thead>
      <tr bgcolor="yellow">
        <th>Employee Id</th>
        <th>Employee Name</th>
        <th>Salary</th>
        <th>Email Address</th>
        <th>password</th>
        <th colspan=2>Action(Delete/Edit)</th>
        
        
      </tr>
    </thead>
    <tbody>
      
      <c:forEach items="${employeeDtoList}" var="tempa">
      
         
		      <tr bgcolor="pink">
		        <td>${tempa.employeeId}</td>
		        <td>${tempa.employeeName}</td>
		        <td>${tempa.salary}</td>
		        <td>${tempa.emailId}</td>
		        <td>${tempa.password}</td>
		        
		        <td>
		        <a href="/deleteEmployee?employeeId=${tempa.employeeId}">
		        <button type="button" class="btn btn-warning">
		        <img src="images/delete.jpg" alt="delete image" style="height:40px">
		        </a>
		       </button></td>
		        <td>
		          <a href="updateEmployee?employeeId=${tempa.employeeId}">
		        <button type="button" class="btn btn-success">
		        <img src="images/edit.jpg" alt="edit image" style="height:40px">
		        </a>
		         </button>
		         </td>
		       
		       
		      </tr>
   
      </c:forEach>
  
    </tbody>
  </table>
  
  
</div>




</body>
</html>