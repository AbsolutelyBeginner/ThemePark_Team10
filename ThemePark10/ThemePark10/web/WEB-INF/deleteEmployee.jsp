<%-- 
    Document   : deleteEmployee
    Created on : Apr 9, 2023, 4:55:26 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Delete Employee</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Delete Employee</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="deleteViewEmployees" method="POST">
        Enter Employee ID: <input type="text" name="empId" required/>
        <br>
        <br>
        <br>        
        <input class="SubmitView" type="submit" value="Delete The Employee" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>