<%-- 
    Document   : viewtickets
    Created on : Apr 7, 2023, 7:36:07 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tickets Information</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
  </head>
  <body>
    <br>
    <a href="manageDashboard">
      <button class="DashView">Return to Dashboard</button>
    </a>
    
    <a href="insertTicket">
      <button class="DashView">Insert New Ticket</button>
    </a>         

    <a href="modifyTicket">
      <button class="DashView">Modify Ticket</button>
    </a>        

    <a href="deleteTicket">
      <button class="DashView">Delete Ticket</button>
    </a>     
    <h1>Tickets Information</h1>
    <table class="tickets">
      <tr>
        <th scope="col">Ticket ID</th>
        <th scope="col">Order ID</th>
        <th scope="col">Ride Names</th>
        <th scope="col">Price</th>
        <th scope="col">Visit Date</th>
      </tr>
      <c:forEach var = "row" items = "${ticketInfo}">
        <tr>
          <td><c:out value = "${row.get(0)}"/></td>
          <td><c:out value = "${row.get(1)}"/></td>
          <td><c:out value = "${row.get(4)}"/></td>
          <td>$<c:out value = "${row.get(2)}"/></td>
          <td><c:out value = "${row.get(3)}"/></td>
        </tr>
      </c:forEach>
<%-- 
      <td>1021491</td>
      <td>1016275</td>
      <td>Wheels of Death, Idk, Something else</td>
      <td>$150</td>
      <td>04/27/2023</td>
--%>
    </table>
</html>
