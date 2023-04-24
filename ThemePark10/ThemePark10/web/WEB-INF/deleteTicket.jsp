<%-- 
    Document   : deleteTicket
    Created on : Apr 11, 2023, 11:07:04 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Delete Ticket</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Delete Ticket</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="deleteViewTickets" method="POST">
        Enter Existing Ticket ID: <input type="text" 
                                         name="ticketId" required />
        <br>
        <br>
        <br>        
        <input class="SubmitView" type="submit" value="Delete The Ticket" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>