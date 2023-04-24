<%-- 
    Document   : viewrides
    Created on : Apr 7, 2023, 6:43:40 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Rides Information</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <br>
    <a href="manageDashboard">
      <button class="rideView">Return to Dashboard</button>
    </a>
   
    <a href="insertRide">
      <button class="rideView">Insert Ride</button>
    </a>         

    <a href="modifyRide">
      <button class="rideView">Modify Ride</button>
    </a>        

    <a href="requestMaintenance">
      <button class="rideView">Request Maintenance</button>
    </a>
    <a href="deleteRide">
      <button class="rideView">Delete Ride</button>
    </a>       

    <a href="modifyMaintenance">
      <button class="rideView">Modify Work Order</button>
    </a> 

    <a href="endMaintenance">
      <button class="rideView">End Work Order</button>
    </a> 

    <a href="deleteMaintenance">
      <button class="rideView">Delete Maintenance</button>
    </a>    

    <h1>Rides Information</h1>
    <table class="rides">
      <tr>
        <th scope="col">Ride Name</th>
        <th scope="col">Height Limit</th>
        <th scope="col">Price</th>
        <th scope="col">Maintenance Status?</th>
      </tr>  
      <c:forEach var = "row" items = "${rideInfo}">
        <tr>
          <td><c:out value = "${row.get(0)}"/></td>
          <td><c:out value = "${row.get(1)}"/></td>
          <td><c:out value = "${row.get(3)}"/></td>
          <c:set var = "NeedM" value = "${row.get(2)}"/>
          <c:choose>
            <c:when test = "${NeedM == '0'}" >
              <td><c:out value = 'Not Needed'/></td>
            </c:when>
            <c:otherwise>
              <td><c:out value = 'Needs Maintenance'/></td> 
            </c:otherwise>
          </c:choose>
        </tr>
      </c:forEach>
    </table>
    <hr>
    <h1>Maintenance</h1>
    <table class="maintenances">
      <tr>
        <th scope="col">Ride Name</th>
        <th scope="col">Maintenance Date</th>
        <th scope="col">Breakdown Date</th>
        <th scope="col">Word Order ID</th>
        <th scope="col">is Completed?</th>
      </tr>
      <c:forEach var = "rowM" items = "${maintInfo}">
        <tr>
          <td><c:out value = "${rowM.get(3)}"/></td>
          <td><c:out value = "${rowM.get(4)}"/></td>
          <td><c:out value = "${rowM.get(2)}"/></td>
          <td><c:out value = "${rowM.get(0)}"/></td>
          <c:set var = "IsC" value = "${rowM.get(1)}"/>
          <c:choose>
            <c:when test = "${IsC == '0'}" >
              <td><c:out value = 'In Progress'/></td>
            </c:when>
            <c:otherwise>
              <td><c:out value = 'Completed'/></td> 
            </c:otherwise>
          </c:choose>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
