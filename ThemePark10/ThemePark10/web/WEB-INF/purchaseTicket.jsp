<%-- 
    Document   : purchase ticket
    Created on : Apr 10, 2023, 3:06:59 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Purchase Tickets</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Purchase Tickets</h1>
    <br>


    <div class="insertTicket">
      &nbsp;  
      <a href="index.jsp">
        <button class="SubmitView"> &nbsp; 
          Abort The Transaction &nbsp; </button>
      </a>
      <br>
      <br>
      <form action="purchaseReport" method="POST">
        Customer Name: <input type="text" name="customerName" required />
        <br>
        <br>
        Tickets Date(MM-DD-YYYY): <input type="text" 
                                         name="ticketDate" required />
        <br>
        <br>
        email: <input type="text" name="email" required />
        <br>
        <br> 
        <div class="ticketError">
          <c:out value = "${ticketMsg}"/> 
        </div>
        <br>        
        <div class="purchaseTicket">
          <table class="tickets">
            <tr>
              <th scope="col">Select Ride(s)</th>
              <th scope="col">Price</th>
              <th scope="col"># of Tickets</th>
            </tr>      
            <c:forEach var = "i" items = "${rideData}" varStatus="status">
              <tr>
                <td>
                  <input type="checkbox" name="rideOptions" value="${i}"/> 
                  <label>
                    <c:out value = "${i}"/> 
                </td>
                <td>
                  $<c:out value = "${priceData.get(status.index)}"/>
                  &nbsp; &nbsp;
                </td>
                <td>
                  <input type="text" size="3" name="numtickets" />
                  </label>
              </tr>
            </c:forEach>
        </div>
        </table>
        <br>
        <input class="SubmitView" type="submit" value="Purchase Tickets" />
    </div>
  </form>
  <br>
</div>
</body>
</html>