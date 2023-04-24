<%-- 
    Document   : insertGiftShop
    Created on : Apr 9, 2023, 7:17:28 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Insert Gift Shop</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Insert Gift Shop</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="insertViewGiftShops" method="POST">
        Employee ID: <input type="text" name="empId" required />
        <br>
        <br>
        <br>
        Shop ID: <input type="text" name="shopId" required />
        <br>
        <br>
        <br>        
        <input class="SubmitView" type="submit" value="Insert Gift Shop" />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>