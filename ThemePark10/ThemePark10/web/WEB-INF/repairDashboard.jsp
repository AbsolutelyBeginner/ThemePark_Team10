<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link href="styledashboards.css" rel="stylesheet"></link>
    <title>Repair Dashboard</title>
  </head>
  <body>
    <header>
      <h1>Repairs Dashboard</h1>
      <button class="logout" onclick="logOut()">Log Out</button>
    </header>

    <div class="tab">
      <button class="tablinks" onclick="openTab(event, 'ride')">Ride Information</button>
    </div>

    <div id="ride" class="tabcontent">
      <h2>Ride Information</h2>
      <p>Information for all the different rides/maintenance date.</p>
      <a href="viewrepairs">
        <button class="view">View Rides</button>
      </a>	
    </div>
    
    <script>
      function openTab(event, tabName)
      {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++)
        {
          tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++)
        {
          tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(tabName).style.display = "block";
        event.currentTarget.className = event.currentTarget.className + " active";
      }
      function logOut()
      {
        window.location.href = "logoutpage.html";
      }
    </script>
  </body>
</html>