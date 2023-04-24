<%-- 
    Document   : selectReport
    Created on : Apr 15, 2023, 10:19:30 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customer Order Information</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
  </head>
  <body class="insertFields">
    <br>
    <a href="manageDashboard">
      <button class="DashView">Return to Dashboard</button>
    </a>
    <h1>Select a Report to View</h1>
 
    <div class="insertTicket">
      <form action="viewSelectedReport" method="POST">
        Select the Report Year <br><br>
        <input type="radio" name="optionYear" 
               checked="checked" value="2023"/>
        Report Year 2023 (Default) <br><br>
        <input type="radio" name="optionYear" 
               value="2022"/>
        
        Report Year 2022 <br><br><br>
        Select the Report <br><br>
        <input type="radio" name="optionReport" 
               checked="checked" value="totalCustomers"/>
        Number of Customers Per Month (Default) <br><br>
        <input type="radio" name="optionReport" 
               value="needMaintenance"/>
        Number of Rides Needing Maintenance Per Month <br><br>
        <input type="radio" name="optionReport" 
               value="riddenRides"/>
        Most Frequently Ridden Rides Per Month <br><br> 
        
        <input class="SubmitView" type="submit" 
               value="View The Report" />
        <br><br>
      </form>    
    </div>  
    <br>
    <%--
    <table class="customer">
      <tr>
        <th scope="col">Order ID</th>
        <th scope="col">Ticket Date</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Order Total</th>
        <th scope="col">Ticket Amount</th>
      </tr>
      <c:forEach var = "row" items = "${customerInfo}">
        <tr>
          <td><c:out value = "${row.get(3)}"/></td>
          <td><c:out value = "${row.get(1)}"/></td>
          <td><c:out value = "${row.get(0)}"/></td>
          <td><c:out value = "${row.get(2)}"/></td>
          <td>$<c:out value = "${row.get(4)}"/></td>
          <td><c:out value = "${row.get(5)}"/></td>
        </tr>
      </c:forEach>
    </table>
    --%>   
  </body>
</html>
