<%-- 
    Document   : delete Maintenance
    Created on : Apr 9, 2023, 1:06:47 AM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Delete Maintenance</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Delete Maintenance</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="deleteViewMaintenance" method="POST">
        Work Order ID: <input type="text" name="orderId" required/>
        <br>
        <br>
        <br>        
        <input class="SubmitView" type="submit" value="Delete A Maintenance Order" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>