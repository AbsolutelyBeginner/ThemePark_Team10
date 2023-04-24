<%-- 
    Document   : insertGift
    Created on : Apr 9, 2023, 7:25:41 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Insert Gift</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Insert Gift</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="insertViewGifts" method="POST">
        Gift ID: <input type="text" name="giftId" required />
        <br>
        <br>
        <br>
        Store ID: <input type="text" name="storeId" required />
        <br>
        <br>
        <br>  
        Price: $<input type="text" name="price" required />
        <br>
        <br>
        <br>         
        <input class="SubmitView" type="submit" value="Insert Gift" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>