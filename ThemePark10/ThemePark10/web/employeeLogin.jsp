<%-- 
    Document   : employeeLogin
    Created on : Apr 9, 2023, 2:14:03 PM
    Author     : ariya.ansari
<script src="functionlogin.js"></script>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="stylelogins.css"/>

    <title>Theme Park Login Page</title>
  </head>
  <body>
    <section>
      <div class = "form-box-login">
        <div class = "form-value">
          <h1>Theme Park Employee</h1>
          <h2>Log In</h2>
          <form action="dashboard" method="POST">
            <div class ="input-box-login">
              <ion-icon name="mail-outline"></ion-icon>
              <input type = "text" name="name" id ="name" required>
              <label>Username</label>
            </div>
            <div class = "input-box-login">
              <ion-icon name="lock-closed-outline"></ion-icon>
              <input type = "password" name="password" id="password" required>
              <label>Password</label>
            </div>

            <div class="button">
              <input class="loginbutton" type="submit" value="Login">
            </div> 
            <br>
            <div class ="copyright">
              <p>Theme Park Management System @ 2023</p>
            </div>                                      
          </form>
        </div>
      </div>
    </section>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
  </body>
</html>
