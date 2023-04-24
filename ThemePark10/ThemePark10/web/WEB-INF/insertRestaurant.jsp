<%-- 
    Document   : insertRestaurant
    Created on : Apr 9, 2023, 6:01:10 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Insert New Restaurant</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Insert a New Restaurant</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="insertViewRestaurants" method="POST">
        Name: <input type="text" name="name" required />
        <br>
        <br>
        <br>
        Manager ID: <input type="text" name="managerId" required />
        <br>
        <br>
        <br>
        Restaurant ID: <input type="text" 
                              name="restaurantId" required />
        <br>
        <br>
        <br>         
        <input class="SubmitView" type="submit" value="Submit New Restaurant" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>