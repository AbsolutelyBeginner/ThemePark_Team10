<%-- 
    Document   : insertTicket
    Created on : Apr 11, 2023, 10:42:49 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Insert New Ticket</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Insert a New Ticket</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="insertViewTickets" method="POST">
        Customer Order ID: <input type="text" 
                                  name="customerId" required />
        <br>
        <br>
        Ride Price: $<input type="text" name="ridePrice" required />
        <br>
        <br>
        Visit Date(MM-DD-YYYY): <input type="text" 
                                       name="visitDate" required />
        <br>
        <br>        
        Ride Name: <input type="text" name="rideN" required/>
        <br>
        <br>        
        <input class="SubmitView" type="submit" value="Submit New Ticket" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>