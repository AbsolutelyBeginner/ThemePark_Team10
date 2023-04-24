<%-- 
    Document   : modifyMaintenance
    Created on : Apr 9, 2023, 1:41:05 AM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Modify Maintenance</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Modify a Maintenance</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="modifyViewMaintenanceRepair" method="POST">
        Work Order ID: <input type="text" name="orderId" required />
        <br>
        <br>
        <br>
        Breakdown Date(MM-DD-YYYY): <input type="text" 
                                           name="bDate" required />
        <br>
        <br>
        <br>        
        Maintenance Date(MM-DD-YYYY): <input type="text" 
                                             name="mDate" required />
        <br>
        <br>
        <br>          
        Is Completed (Yes/No)? <input type="text" 
                                      name="isComplete" required />
        <br>
        <br>
        <br>          
        <input class="SubmitView" type="submit" value="Modify Work Order" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>