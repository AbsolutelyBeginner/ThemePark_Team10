<%-- 
    Document   : viewrestaurants
    Created on : Apr 7, 2023, 10:32:08 PM
    Author     : ariya.ansari
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Restaurants Information</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
  </head>
  <body>
    <br>
    <a href="manageDashboard">
      <button class="DashView">Return to Dashboard</button>
    </a>
    
    <a href="insertRestaurant">
      <button class="DashView">Insert New Restaurant</button>
    </a>         

    <a href="modifyRestaurant">
      <button class="DashView">Modify Restaurant</button>
    </a>        

    <a href="deleteRestaurant">
      <button class="DashView">Delete Restaurant</button>
    </a> 
    
    <h1>Restaurants Information</h1>
    <table class="game">
      <tr>
        <th scope="col">Name</th>
        <th scope="col">Manager ID</th>
        <th scope="col">Restaurant ID</th>
      </tr>
      <c:forEach var = "row" items = "${restaurantInfo}">
        <tr>
          <td><c:out value = "${row.get(0)}"/></td>
          <td><c:out value = "${row.get(1)}"/></td>
          <td><c:out value = "${row.get(2)}"/></td>
        </tr>
      </c:forEach>
    </table>

  </body>
</html>
