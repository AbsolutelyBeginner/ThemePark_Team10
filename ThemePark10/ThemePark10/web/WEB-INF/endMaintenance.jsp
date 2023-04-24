<%-- 
    Document   : endMaintenance
    Created on : Apr 9, 2023, 8:35:33 AM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Complete Maintenance</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Complete A Maintenance Work</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="modifyViewMaintenance" method="POST">
        Work Order ID: <input type="text" name="orderId" required/>
        <br>
        <br>
        <br>      
        Maintenance Date(MM-DD-YYYY): <input type="text" 
                                             name="mDate" required/>
        <br>
        <br>
        <br>  
        <input type="hidden" name="isComplete" value="Yes"/>        
        <input class="SubmitView" type="submit" value="Complete Maintenance" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>