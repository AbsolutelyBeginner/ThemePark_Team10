<%-- 
    Document   : deleteGiftShop
    Created on : Apr 9, 2023, 7:49:37 PM
    Author     : ariya.ansari
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Delete Gift Shop</title>
    <link rel="stylesheet" href="styleWebInf.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body class="insertFields">
    <h1>Delete Gift Shop</h1>
    <br>
    <div class="insertArea">
      <br>
      <form action="deleteViewGiftShops" method="POST">
        Shop ID: <input type="text" name="shopId" />
        <br>
        <br>
        <br>        
        <input class="SubmitView" type="submit" 
               value="Delete Gift Shop" required />
        <br>
      </form>
      <br>
    </div>
  </body>
</html>