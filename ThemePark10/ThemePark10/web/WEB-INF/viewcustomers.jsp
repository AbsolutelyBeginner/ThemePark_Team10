<%-- 
    Document   : viewcustomers
    Created on : Apr 7, 2023, 7:57:44 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customer Order Information</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
  </head>
  <body>
    <br>
    <a href="manageDashboard">
      <button class="DashView">Return to Dashboard</button>
    </a>

    <a href="insertCustomer">
      <button class="DashView">Insert New Customer</button>
    </a>         

    <a href="modifyCustomer">
      <button class="DashView">Modify Customer</button>
    </a>        

    <a href="deleteCustomer">
      <button class="DashView">Delete Customer</button>
    </a> 
    
    <h1>Orders Information</h1>
    <table class="customer">
      <tr>
        <th scope="col">Order ID</th>
        <th scope="col">Ticket Date</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Order Total</th>
        <th scope="col">Ticket Amount</th>
      </tr>
      <c:forEach var = "row" items = "${customerInfo}">
        <tr>
          <td><c:out value = "${row.get(3)}"/></td>
          <td><c:out value = "${row.get(1)}"/></td>
          <td><c:out value = "${row.get(0)}"/></td>
          <td><c:out value = "${row.get(2)}"/></td>
          <td>$<c:out value = "${row.get(4)}"/></td>
          <td><c:out value = "${row.get(5)}"/></td>
        </tr>
      </c:forEach>
      <%--     
            <td>obanhmiga@gmail.com</td>
            <td>Huy Vo</td>
            <td>1016275</td>
            <td>$150</td>
            <td>3</td>
      --%>

    </table>
  </body>
</html>
