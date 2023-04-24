<%-- 
    Document   : deleteGift
    Created on : Apr 9, 2023, 8:24:11 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Delete Gift</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Delete Gift</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="deleteViewGifts" method="POST">
        Existing Gift ID: <input type="text" name="giftId" required />
        <br>
        <br>
        <br>        
        <input class="SubmitView" type="submit" value="Delete Gift" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>