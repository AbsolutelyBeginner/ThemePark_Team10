<%-- 
    Document   : viewSelectedReport
    Created on : Apr 15, 2023, 11:47:27 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View Report</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
  </head>
  <body>
    <br>
    &nbsp;
    <a href="manageDashboard">
      <button class="DashView"> Return to Dashboard </button>
    </a>
    &nbsp;
    <a href="selectReport">
      <button class="DashView">Report Selection</button>
    </a>

    <h2>${reportType}</h2>

    <div  class="customerTable">
      <div class="customerSummary">
        <center>
        <c:forEach var = "sumRow" items = "${summaryReport}">
          <br>
          <c:forEach var = "sumCell" items = "${sumRow}">
            <c:out value = "${sumCell}"/>
          </c:forEach>
          <br>
        </c:forEach> 
          <br>
          </center>
      </div>
      <br>
      <table class="customer">
        <tr>
          <c:forEach var = "column" items = "${reportColumns}">  
            <th scope="col"><c:out value = "${column}"/></th>
            </c:forEach>
        </tr>
        <c:forEach var = "row" items = "${reportInfo}">
          <tr>
            <c:forEach var = "cell" items = "${row}">
              <td><c:out value = "${cell}"/></td>
            </c:forEach>
          </tr>
        </c:forEach>
      </table>
    </div>
    <br><br>
  </body>
</html>