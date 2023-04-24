<%-- 
    Document   : deleteRestaurant
    Created on : Apr 9, 2023, 6:06:49 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Delete Restaurant</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Delete a Restaurant</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="deleteViewRestaurants" method="POST">
        Restaurant ID: <input type="text" name="restaurantId" required/>
        <br>
        <br>
        <br>         
        <input class="SubmitView" type="submit" value="Delete Restaurant" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>