<%-- 
    Document   : modifyEmployee
    Created on : Apr 9, 2023, 5:02:38 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Modify Employee</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Modify Employee</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="modifyViewEmployees" method="POST">
        Existing Employee ID: <input type="text" 
                                     name="empId" required />
        <br>
        <br>        
        First Name: <input type="text" name="fName" required />
        <br>
        <br>
        Last Name: <input type="text" name="lName" required />
        <br>
        <br>
        email: <input type="text" name="email" required />
        <br>
        <br>  
        Password: <input type="text" name="password" required />
        <br>
        <br>       
        Birth Date(MM-DD-YYYY): <input type="text" 
                                       name="birthDate" required />
        <br>
        <br>
        Gender: <input type="text" name="gender" required />
        <br>
        <br>         
        SSN(XXX-XX-XXXX): <input type="text" name="ssn" required />
        <br>
        <br>        
        Salary: $<input type="text" name="salary" required />
        <br>
        <br>
        Position: <input type="text" name="position" required />
        <br>
        <br>       
        <input class="SubmitView" type="submit" value="Modify Employee" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>