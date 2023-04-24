<%-- 
    Document   : insertCustomer
    Created on : Apr 9, 2023, 9:08:30 AM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Insert New Customer</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Insert a New Customer</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="insertViewCustomers" method="POST">
        Customer Name: <input type="text" 
                              name="customerName" required />
        <br>
        <br>
        Ticket Date(MM-DD-YYYY): <input type="text" 
                                        name="ticketDate" required />
        <br>
        <br>
        email: <input type="text" name="email" required />
        <br>
        <br>        
        Order Amount: $<input type="text" 
                              name="orderAmount" required />
        <br>
        <br>
        Ticket Amount: <input type="text" 
                              name="ticketAmount" required />
        <br>
        <br>        
        <input class="SubmitView" type="submit" 
               value="Submit New Customer" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>