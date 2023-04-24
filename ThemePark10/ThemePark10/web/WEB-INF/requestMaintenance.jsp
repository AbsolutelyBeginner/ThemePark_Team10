<%-- 
    Document   : needMaintenance
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Request Maintenance</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Request Maintenance for a Ride</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="requestViewRides" method="POST">
        Ride Name: <input type="text" name="rideName" />
        <br>
        <br>
        <br>       
        <input class="SubmitView" type="submit" 
               value="Request Maintenance" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>