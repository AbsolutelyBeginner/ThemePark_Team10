<%-- 
    Document   : viewgames
    Created on : Apr 7, 2023, 8:14:58 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Carnival Games Information</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
  </head>
  <body>
    <br>
    <a href="manageDashboard">
      <button class="DashView">Return to Dashboard</button>
    </a>

    <a href="insertGiftShop">
      <button class="DashView">Insert Gift Shop</button>
    </a>                

    <a href="deleteGiftShop">
      <button class="DashView">Delete Gift Shop</button>
    </a>       

    <a href="insertGift">
      <button class="DashView">Insert Gift</button>
    </a>         

    <a href="deleteGift">
      <button class="DashView">Delete Gift</button>  
    </a> 

    <a href="insertGame">
      <button class="DashView">Insert Game</button>
    </a>         

    <a href="deleteGame">
      <button class="DashView">Delete Game</button>  
    </a>     
    
    <h1>Carnival Games Information</h1>
    <table class="game">
      <tr>
        <th scope="col">Game ID</th>
        <th scope="col">Name</th>
        <th scope="col">Employee ID</th>
      </tr>
      <c:forEach var = "rowCa" items = "${gameInfo}">
        <tr>
          <td><c:out value = "${rowCa.get(0)}"/></td>
          <td><c:out value = "${rowCa.get(2)}"/></td>
          <td><c:out value = "${rowCa.get(1)}"/></td>
        </tr>
      </c:forEach>
      <%--
      <td>1</td>
      <td>League of Legends</td>
      <td>1816275</td>
      --%>
    </table>
    <hr>
    <h1>Gifts Information</h1>
    <table class="gifts">
      <tr>
        <th scope="col">Shop ID</th>
        <th scope="col">Employee ID</th>
        <th scope="col">Gift ID</th>
        <th scope="col">Price</th>
      </tr>
      <c:forEach var = "rowG" items = "${giftInfo}">
        <tr>
          <td><c:out value = "${rowG.get(1)}"/></td>
          <td><c:out value = "${rowG.get(3)}"/></td>
          <td><c:out value = "${rowG.get(0)}"/></td>
          <td>$<c:out value = "${rowG.get(2)}"/></td>
        </tr>
      </c:forEach>

    </table>
  </body>
</html>
