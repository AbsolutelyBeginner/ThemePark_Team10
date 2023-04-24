<%-- 
    Document   : purchase
    Created on : Apr 11, 2023, 4:58:10 PM
    Author     : mansoor.ansari
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Payment page</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
  </head>
  <body class="insertFields">
    <h1>Payment</h1>
    <br>
    <div class="insertTicket">
      <br>
      <c:forEach var = "ride" items = "${rideOp}" varStatus="status">
        &nbsp; &nbsp; <c:out value = "${numberTic[status.index]}"/>
        <c:out value = "${ride}"/> ticket
        <br><br>
      </c:forEach> 
      &nbsp; &nbsp; Total Tickets: ${totalTickets} 
      <br><br>
      &nbsp; &nbsp; Total Cost: $${totalAmount}
      <br><br>
      <a href="index.jsp">
      <button class="SubmitView">Done</button>
    </a> 
    </div>      
  </body>
</html>
