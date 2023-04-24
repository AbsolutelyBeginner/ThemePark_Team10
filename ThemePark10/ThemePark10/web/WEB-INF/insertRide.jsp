<%-- 
    Document   : insert ride
    Created on : Apr 7, 2023, 6:43:40 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Insert New Ride</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Insert a New Ride</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="insertViewRides" method="POST">
        Ride Name: <input type="text" name="rideName" required />
        <br>
        <br>
        <br>
        Height Limit: <input type="text" name="heightLimit" required />
        <br>
        <br>
        <br> 
        Price: <input type="text" name="price" required />
        <br>
        <br>
        <br>         
        <input class="SubmitView" type="submit" value="Submit New Ride" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>