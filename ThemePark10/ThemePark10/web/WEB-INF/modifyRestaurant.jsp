<%-- 
    Document   : modifyRestaurant
    Created on : Apr 9, 2023, 6:10:24 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Update Restaurant</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Update a Restaurant</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="modifyViewRestaurants" method="POST">
        Existing Restaurant ID: <input type="text" 
                                       name="restaurantId" required />
        <br>
        <br>
        <br>         
        Name: <input type="text" name="name" required />
        <br>
        <br>
        <br>
        Manager ID: <input type="text" name="managerId" required />
        <br>
        <br>
        <br>        
        <input class="SubmitView" type="submit" value="Update The Restaurant" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>