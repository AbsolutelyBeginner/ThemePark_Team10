<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link href="styledashboards.css" rel="stylesheet"></link>
    <title>Manager Dashboard</title>

  </head>
  <body>
    <header>
      <h1>Manager Dashboard</h1>
      <button class="logout" onclick="logOut()">Log Out</button>

    </header>
    <div class="tab">
      <button class="tablinks" onclick="openTab(event, 'ride')">Ride Information</button>
      <button class="tablinks" onclick="openTab(event, 'ticket')">Ticket Pricing</button>
      <button class="tablinks" onclick="openTab(event, 'customerinfo')">Customer Information</button>
      <button class="tablinks" onclick="openTab(event, 'gamesgifts')">Games and Giftshops</button>
      <button class="tablinks" onclick="openTab(event, 'restaurants')">Restaurants Sales</button>
      <button class="tablinks" onclick="openTab(event, 'employees')">Employees Management</button>
      <button class="tablinks" onclick="openTab(event, 'reports')">Reports</button>
    </div>
    <div id="ride" class="tabcontent">
      <h2>Ride Information</h2>
      <p>Information for all the different rides/maintenance date.</p>
      <a href="viewrides">
        <button class="view">View Rides</button>
      </a>	
    </div>
    <div id="ticket" class="tabcontent">
      <h2>Ticket Information</h2>
      <p>View Ticket Information</p>
      <a href="viewtickets">
        <button class="view">View Tickets</button>
      </a>	
    </div>
    <div id="customerinfo" class="tabcontent">
      <h2>Customer Information</h2>
      <p>Add, Modify the Customers Information</p>
      <a href="viewcustomers">
        <button class="view">View Customers</button>
      </a>			
    </div>
    <div id="gamesgifts" class="tabcontent">
      <h2>Games and Gift shops</h2>
      <p>Adjust sales for games and giftshops</p>
      <a href="viewgames">
        <button class="view">View Games & Giftshops</button>
      </a>	
    </div>
    <div id="restaurants" class="tabcontent">
      <h2>Restaurants</h2>
      <p>Set the value of daily input for restaurants sales</p>
      <a href="viewrestaurants">
        <button class="view">View Restaurants Sales</button>
      </a>	
    </div>
    <div id="employees" class="tabcontent">
      <h2>Employees Management</h2>
      <p>Modify/View of concurrent employees</p>
      <a href="viewemployees">
        <button class="view">View Employees</button>
      </a>	
    </div>
    <div id="reports" class="tabcontent">
      <h2>Reports Managment for Manager</h2>
      <p>View of reports of manager side</p>
      <a href="selectReport">
        <button class="view">Select A Report</button>
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

