<%-- 
    Document   : purchaseTicketError
    Created on : Apr 19, 2023, 9:38:47 AM
    Author     : ariya.ansari
    <meta http-equiv="refresh" content="0; url=purchaseTicket" />  

--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Redirect Page</title>
  </head>
  <body>
    <h1>Moving quickly from here!</h1>
    <%
    response.sendRedirect(request.getContextPath() + 
      "/purchaseTicket");
    %>
  </body>
</html>