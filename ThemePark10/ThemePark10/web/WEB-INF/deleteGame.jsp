<%-- 
    Document   : deleteGame
    Created on : Apr 9, 2023, 8:28:57 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Delete Game</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Delete Game</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="deleteViewGames" method="POST">
        Existing Game ID: <input type="text" name="gameId" required/>
        <br>
        <br>
        <br>        
        <input class="SubmitView" type="submit" value="Delete Game" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>