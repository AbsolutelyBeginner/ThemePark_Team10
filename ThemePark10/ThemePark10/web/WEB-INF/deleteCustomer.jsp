<%-- 
    Document   : deleteCustomer
    Created on : Apr 9, 2023, 10:19:55 AM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Delete Customer</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Delete Customer</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="deleteViewCustomers" method="POST">
        Enter Existing Order ID: <input type="text" name="orderId" required />
        <br>
        <br>
        <br>        
        <input class="SubmitView" type="submit" value="Delete The Customer" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>