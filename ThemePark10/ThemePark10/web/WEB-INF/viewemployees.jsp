<%-- 
    Document   : viewemployees
    Created on : Apr 7, 2023, 10:51:36 PM
    Author     : ariya.ansari
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="styleWebInf.css"/>
    <title>Employee Information</title>
  </head>
  <body>
    <br>
    <a href="manageDashboard">
      <button class="DashView">Return to Dashboard</button>
    </a>

    <a href="insertEmployee">
      <button class="DashView">Insert New Employee</button>
    </a>         

    <a href="modifyEmployee">
      <button class="DashView">Modify Employee</button>
    </a>        

    <a href="deleteEmployee">
      <button class="DashView">Delete Employee</button>
    </a> 
    
    <h1>Employees Information</h1>
    <table class="employee">
      <tr>
        <th scope = "col">First Name</th>
        <th scope = "col">Last Name</th>
        <th scope = "col">Employee ID</th>
        <th scope = "col">Birth Date</th>
        <th scope = "col">Sex</th>
        <th scope = "col">Email</th>
        <th scope = "col">SSN</th>
        <th scope = "col">Salary</th>
        <th scope = "col">Position</th>
      </tr>
      <c:forEach var = "row" items = "${employeeInfo}">
        <tr>
          <td><c:out value = "${row.get(0)}"/></td>
          <td><c:out value = "${row.get(2)}"/></td>
          <td><c:out value = "${row.get(4)}"/></td>
          <td><c:out value = "${row.get(6)}"/></td>
          <td><c:out value = "${row.get(7)}"/></td>
          <td><c:out value = "${row.get(3)}"/></td>
          <td><c:out value = "${row.get(8)}"/></td>
          <td><c:out value = "${row.get(9)}"/></td>
          <td><c:out value = "${row.get(10)}"/></td>
        </tr>
      </c:forEach>	
      <%--
      <tr>
        <td>Joe</td>
        <td>Biden</td>
        <td>1816275</td>
        <td>12-01-1975</td>
        <td>Male</td>
        <td>joebiden69@gmail.com</td>
        <td>2136899996</td>
        <td>123456789</td>
        <td>1000000</td>
        <td>Manager</td>
      </tr>

      <tr>
        <td>Obama</td>
        <td>Barack</td>
        <td>6278910</td>
        <td>01-09-1967</td>
        <td>Male</td>
        <td>barackobamajoe@gmail.com</td>
        <td>1494568901</td>
        <td>132459867</td>
        <td>60000</td>
        <td>Employee</td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
--%>
    </table>
  </body>
</html>
