<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="stylelogins.css"/>
    <script src="functionlogin.js"></script>
    <title>ThemePark Page</title>
  </head>
  <body>
    <section>
      <div class = "form-box-login">
        <div class = "form-value">
          <h2>Theme Park <br> Project Ten</h2>
          <br><br><br>
          <center>
            <div>
              <a href="employeeLogin.jsp">
                <button class="MainView">Employee Login</button>
              </a>
              <a href="purchaseTicket">
                <button class="MainView">Purchase Tickets</button>
              </a>
            </div>
            <br><br>
            <div class ="copyright">
              <p>Theme Park Management System @ 2023</p>
            </div> 
          </center>



          <%--
            <form action="">
                <h1>Theme Park Database</h1>
                  
                <h2>Log In</h2>
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
                <div class="forget">
                    <label for=""><a href="forgotpass.html"><br>Forgor Password? &#9760;</a></label>                       
                </div>
                <div class="button">
                    <input class="loginbutton" type="button" value="Login" onclick="checkValidation()">
                </div>                       
                <div class="register">
                    <p>Don't have an account? <a href="registerpage.html">Register</a></p>
                </div>
                <div class ="copyright">
                    <p>Theme Park Management System @ 2023</p>
                </div>                                      
            </form>
          --%>
        </div>
      </div>
    </section>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
  </body>
</html>
