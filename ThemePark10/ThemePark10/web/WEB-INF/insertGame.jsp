<%-- 
    Document   : insertGame
    Created on : Apr 9, 2023, 8:12:51 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Insert Game</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Insert Game</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="insertViewGames" method="POST">
        Game ID: <input type="text" name="gameId" required />
        <br>
        <br>
        <br>
        Employee ID: <input type="text" name="empId" required />
        <br>
        <br>
        <br>  
        Attraction: <input type="text" name="attraction" required />
        <br>
        <br>
        <br>         
        <input class="SubmitView" type="submit" value="Insert Game" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>