// Ariya Ansari

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

@WebServlet(name = "Controller",
  loadOnStartup = 1,
  urlPatterns =
  {
    "/viewrides", "/viewtickets", "/viewcustomers",
    "/viewgames", "/viewrestaurants", "/viewemployees",
    "/insertRide", "/insertViewRides",
    "/deleteRide", "/deleteViewRides",
    "/modifyRide", "/modifyViewRides",
    "/deleteMaintenance", "/deleteViewMaintenance",
    "/modifyMaintenance", "/modifyViewMaintenance",
    "/requestMaintenance", "/requestViewRides",
    "/endMaintenance",
    "/insertCustomer", "/insertViewCustomers",
    "/deleteCustomer", "/deleteViewCustomers",
    "/modifyCustomer", "/modifyViewCustomers",
    "/insertTicket", "/insertViewTickets",
    "/deleteTicket", "/deleteViewTickets",
    "/modifyTicket", "/modifyViewTickets",
    "/insertEmployee", "/insertViewEmployees",
    "/deleteEmployee", "/deleteViewEmployees",
    "/modifyEmployee", "/modifyViewEmployees",
    "/insertRestaurant", "/insertViewRestaurants",
    "/deleteRestaurant", "/deleteViewRestaurants",
    "/modifyRestaurant", "/modifyViewRestaurants",
    "/insertGiftShop", "/insertViewGiftShops",
    "/deleteGiftShop", "/deleteViewGiftShops",
    "/insertGift", "/insertViewGifts",
    "/deleteGift", "/deleteViewGifts",
    "/insertGame", "/insertViewGames",
    "/deleteGame", "/deleteViewGames",
    "/purchaseTicket", "/purchaseReport",
    "/selectReport", "/viewSelectedReport",
    "/manageDashboard", "/dashboard",
    "/viewrepairs", "/repairDashboard",
    "/modifyMaintenanceRepair", "/modifyViewMaintenanceRepair",
    "/dbPage"
  })
public class Controller extends HttpServlet
{

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter())
    {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet Controller</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    // session object to communicate data
    HttpSession session = request.getSession();
    // key word sent by the client page
    String userPath = request.getServletPath();

    if (userPath.equals("/insertRide")
      || userPath.equals("/deleteRide")
      || userPath.equals("/modifyRide")
      || userPath.equals("/requestMaintenance")
      || userPath.equals("/deleteMaintenance")
      || userPath.equals("/modifyMaintenance")
      || userPath.equals("/endMaintenance")
      || userPath.equals("/insertCustomer")
      || userPath.equals("/deleteCustomer")
      || userPath.equals("/modifyCustomer")
      || userPath.equals("/insertTicket")
      || userPath.equals("/deleteTicket")
      || userPath.equals("/modifyTicket")
      || userPath.equals("/insertEmployee")
      || userPath.equals("/deleteEmployee")
      || userPath.equals("/modifyEmployee")
      || userPath.equals("/insertRestaurant")
      || userPath.equals("/deleteRestaurant")
      || userPath.equals("/modifyRestaurant")
      || userPath.equals("/insertGiftShop")
      || userPath.equals("/deleteGiftShop")
      || userPath.equals("/insertGift")
      || userPath.equals("/deleteGift")
      || userPath.equals("/insertGame")
      || userPath.equals("/deleteGame")
      || userPath.equals("/selectReport")
      || userPath.equals("/repairDashboard")
      || userPath.equals("/modifyMaintenanceRepair")
      || userPath.equals("/manageDashboard"))
    {
      // URL to go back to
      String myUrl = "/WEB-INF" + userPath + ".jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/viewrides"))
    {
      // db info
      String dbName = "Theme_Park";
      String tableName = "Ride";
      String[] columnNames =
      {
        "Ride_Name", "HeightLimit", "NeedsMaintenance", "Price"
      };
      JavaDatabase objDb = new JavaDatabase(dbName);
      ArrayList<ArrayList<String>> data
        = objDb.getData(tableName, columnNames);
      session.setAttribute("rideInfo", data);
      String tableNameM = "Maintenance";
      String[] columnNamesM =
      {
        "WorkOrderID", "IsCompleted", "BreakdownDate",
        "R_Name", "MaintenanceDate"
      };
      ArrayList<ArrayList<String>> dataM
        = objDb.getData(tableNameM,
          columnNamesM);
      System.out.println(dataM);
      session.setAttribute("maintInfo", dataM);
      // URL to go back to
      String myUrl = "/WEB-INF" + userPath + ".jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/viewrepairs"))
    {
      // db info
      String dbName = "Theme_Park";
      String tableName = "Ride";
      String[] columnNames =
      {
        "Ride_Name", "HeightLimit", "NeedsMaintenance"
      };
      JavaDatabase objDb = new JavaDatabase(dbName);
      ArrayList<ArrayList<String>> data
        = objDb.getData(tableName, columnNames);
      session.setAttribute("rideInfo", data);
      String tableNameM = "Maintenance";
      String[] columnNamesM =
      {
        "WorkOrderID", "IsCompleted", "BreakdownDate",
        "R_Name", "MaintenanceDate"
      };
      ArrayList<ArrayList<String>> dataM
        = objDb.getData(tableNameM,
          columnNamesM);
      System.out.println(dataM);
      session.setAttribute("maintInfo", dataM);
      // URL to go back to
      String myUrl = "/WEB-INF" + userPath + ".jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/viewtickets"))
    {
      // db info
      String dbName = "Theme_Park";
      String tableName = "Ticket";
      String[] columnNames =
      {
        "TicketID", "Customer_ID", "RidePrice",
        "VisitDate", "Ride_N"
      };
      JavaDatabase objDb = new JavaDatabase(dbName);
      ArrayList<ArrayList<String>> data
        = objDb.getData(tableName, columnNames);

      session.setAttribute("ticketInfo", data);
      // URL to go back to
      String myUrl = "/WEB-INF" + userPath + ".jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    else if (userPath.equals("/viewcustomers"))
    {
      // db info
      String dbName = "Theme_Park";
      String tableName = "Customer_Order";
      String[] columnNames =
      {
        "Name", "Ticket_Date", "Email", "OrderID",
        "OrderTotal", "TicketAmount"
      };
      JavaDatabase objDb = new JavaDatabase(dbName);
      ArrayList<ArrayList<String>> data
        = objDb.getData(tableName, columnNames);

      session.setAttribute("customerInfo", data);
      // URL to go back to
      String myUrl = "/WEB-INF" + userPath + ".jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    else if (userPath.equals("/viewgames"))
    {
      // db info
      String dbName = "Theme_Park";
      String tableNameCa = "CarnivalAttraction";
      String[] columnNamesCa =
      {
        "GameID", "E_ID", "Attraction"
      };
      JavaDatabase objDb = new JavaDatabase(dbName);
      ArrayList<ArrayList<String>> dataCa
        = objDb.getData(tableNameCa,
          columnNamesCa);
      session.setAttribute("gameInfo", dataCa);
      String tableNameGs = "Gift_Shop";
      String[] columnNamesGs =
      {
        "Employee_ID", "Shop_ID"
      };
      ArrayList<ArrayList<String>> dataGs
        = objDb.getData(tableNameGs,
          columnNamesGs);
      //session.setAttribute("giftShopInfo", dataGs);
      String tableNameG = "Gifts";
      String[] columnNamesG =
      {
        "GiftID", "Store_ID", "Price"
      };
      ArrayList<ArrayList<String>> dataG
        = objDb.getData(tableNameG,
          columnNamesG);
      joinGiftShop(dataGs, dataG);
      session.setAttribute("giftInfo", dataG);
      // URL to go back to
      String myUrl = "/WEB-INF" + userPath + ".jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    else if (userPath.equals("/viewrestaurants"))
    {
      // db info
      String dbName = "Theme_Park";
      String tableName = "Restaurant";
      String[] columnNames =
      {
        "Name", "Manager_ID", "RestaurantID"
      };
      JavaDatabase objDb = new JavaDatabase(dbName);
      ArrayList<ArrayList<String>> data
        = objDb.getData(tableName, columnNames);

      session.setAttribute("restaurantInfo", data);
      // URL to go back to
      String myUrl = "/WEB-INF" + userPath + ".jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    else if (userPath.equals("/viewemployees"))
    {
      // db info
      String dbName = "Theme_Park";
      String tableName = "Employee";
      String[] columnNames =
      {
        "FName", "MName", "LName", "Email", "Emp_ID", "Password",
        "Birth_Date", "Sex", "SSN", "Salary", "Position"
      };
      JavaDatabase objDb = new JavaDatabase(dbName);
      ArrayList<ArrayList<String>> data
        = objDb.getData(tableName, columnNames);

      session.setAttribute("employeeInfo", data);
      // URL to go back to
      String myUrl = "/WEB-INF" + userPath + ".jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/purchaseTicket"))
    {
      String dbName = "Theme_Park";
      JavaDatabase objDb = new JavaDatabase(dbName);
      ArrayList<String> rideData = objDb.getRideNames();
      ArrayList<Double> priceData = objDb.getRidePrices();
      session.setAttribute("rideData", rideData);
      session.setAttribute("priceData", priceData);
      String myUrl = "/WEB-INF" + userPath + ".jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    // session object to communicate data
    HttpSession session = request.getSession();
    // key word sent by the client page
    String userPath = request.getServletPath();
    if (userPath.equals("/viewSelectedReport"))
    {
      ProduceReport objR = new ProduceReport();
      ArrayList<ArrayList<String>> reportInfo
        = new ArrayList<>();
      ArrayList<String> reportColumns = new ArrayList<>();
      String optionYear = request.getParameter("optionYear");
      String optionReport = request.getParameter("optionReport");

      if (optionReport.equals("needMaintenance"))
      {
        ArrayList<ArrayList<String>> data = getMaintenance();
        reportInfo = objR.maintenanceReport(data, optionYear);

        ArrayList<ArrayList<String>> summaryReport
          = new ArrayList<>();
        summaryReport.add(
          reportInfo.remove(reportInfo.size() - 1));
        summaryReport.add(
          reportInfo.remove(reportInfo.size() - 1));
        session.setAttribute("summaryReport", summaryReport);

        reportColumns.add("Month");
        reportColumns.add("# Of Rides");
        session.setAttribute("reportType",
          ("Rides Needing Maintenance Per Month In " + optionYear));
      }
      else if (optionReport.equals("riddenRides"))
      {
        ArrayList<ArrayList<String>> data = getTickets();
        reportInfo = objR.ridesReport(data, optionYear);

        ArrayList<ArrayList<String>> summaryReport = new ArrayList<>();
        summaryReport.add(
          reportInfo.remove(reportInfo.size() - 1));
        summaryReport.add(
          reportInfo.remove(reportInfo.size() - 1));
        session.setAttribute("summaryReport", summaryReport);

        reportColumns.add("Month");
        reportColumns.add("Ride Name");
        reportColumns.add("Ridden Numbers");

        session.setAttribute("reportType",
          ("Most Frequently Ridden Rides Per Month In " + optionYear));
      }
      else //if optionReport.equals("totalCustomers")
      {
        ArrayList<ArrayList<String>> data = getCustomers();
        reportInfo = objR.customerReport(data, optionYear);

        ArrayList<ArrayList<String>> summaryReport = new ArrayList<>();
        summaryReport.add(
          reportInfo.remove(reportInfo.size() - 1));
        summaryReport.add(
          reportInfo.remove(reportInfo.size() - 1));
        session.setAttribute("summaryReport", summaryReport);

        reportColumns.add("Month");
        reportColumns.add("# Of Customers");
        session.setAttribute("reportType",
          "Customers Per Month In " + optionYear);
      }
      session.setAttribute("reportYear", optionYear);
      session.setAttribute("reportColumns", reportColumns);
      session.setAttribute("reportInfo", reportInfo);
      // URL to go back to
      String myUrl = "/WEB-INF/viewSelectedReport.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    else if (userPath.equals("/dashboard"))
    {
      String name = request.getParameter("name");
      String password = request.getParameter("password");
      // db info
      String dbName = "Theme_Park";
      String tableName = "Employee";

      JavaDatabase objDb = new JavaDatabase(dbName);
      String[] loginData = objDb.validate(dbName, tableName,
        name, password);
      if (loginData[0].equals("false"))
      {
        // URL to go back to
        String myUrl = "loginFailed.jsp";
        try
        {
          // redirect back to new URL with new data
          request.getRequestDispatcher(myUrl).forward(request, response);
        }
        catch (Exception ex)
        {
          request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
        }
      }
      else
      {
        if (loginData[1].equals("Manager"))
        {
          // URL to go back to
          String myUrl = "/WEB-INF/manageDashboard.jsp";
          try
          {
            // redirect back to new URL with new data
            request.getRequestDispatcher(myUrl).forward(request, response);
          }
          catch (Exception ex)
          {
            request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
          }
        }
        else if (loginData[1].equals("Repair"))
        {
          // URL to go back to
          String myUrl = "/WEB-INF/repairDashboard.jsp";
          try
          {
            // redirect back to new URL with new data
            request.getRequestDispatcher(myUrl).forward(request, response);
          }
          catch (Exception ex)
          {
            request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
          }
        }
        else
        {
          // URL to go back to
          String myUrl = "/WEB-INF/repairDashboard.jsp";
          try
          {
            // redirect back to new URL with new data
            request.getRequestDispatcher(myUrl).forward(request, response);
          }
          catch (Exception ex)
          {
            request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
          }
        }
      }
    }

    else if (userPath.equals("/purchaseReport"))
    {
      String customerName
        = request.getParameter("customerName");
      String tempDate
        = request.getParameter("ticketDate");
      ProduceReport objRep = new ProduceReport();
      String ticketDate = objRep.parseDate(tempDate);
      String email
        = request.getParameter("email");
      String[] rideOptions
        = request.getParameterValues("rideOptions");
      String[] numbertickets
        = request.getParameterValues("numtickets");
      checkOptions(rideOptions, numbertickets);

      if (!checkOptions(rideOptions, numbertickets))
      {
        session.setAttribute("ticketMsg",
          "Please select Ride(s) & # of tickets "
          + "to purchase");
        String myUrl = "/WEB-INF" + "/purchaseTicketError.jsp";
        try
        {
          // redirect back to new URL with new data
          request.getRequestDispatcher(myUrl).forward(request, response);
        }
        catch (Exception ex)
        {
          request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
        }
      }
      else
      {

        String dbName = "Theme_Park";
        JavaDatabase objDb = new JavaDatabase(dbName);
        ArrayList<ArrayList<String>> rideData
          = objDb.getRideAndPrice();

        double[] ticketCost = new double[rideOptions.length];
        for (int r = 0; r < rideOptions.length; r++)
        {
          for (int k = 0; k < rideData.size(); k++)
          {
            if (rideOptions[r].equalsIgnoreCase(
              rideData.get(k).get(0)))
            {
              // enter ticket cost for a checked ride
              ticketCost[r] = Double.parseDouble(
                rideData.get(k).get(1));
              // if forgot to enter # of tickets for a checked ride
              if (numbertickets[k].equals(""))
              {
                numbertickets[k] = "1";
              }
              k = rideData.size();
            }
          }
        }

        // count total tickets
        int counter = 0;
        for (int i = 0; i < numbertickets.length; i++)
        {
          if (!numbertickets[i].equals(""))
          {
            counter++;
          }
        }
        if (rideOptions.length < counter)
        {
          session.setAttribute("ticketMsg",
            "Please select Ride(s) & # of tickets "
            + "to purchase");
          String myUrl = "/WEB-INF" + "/purchaseTicketError.jsp";
          try
          {
            // redirect back to new URL with new data
            request.getRequestDispatcher(myUrl).forward(request, response);
          }
          catch (Exception ex)
          {
            request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
          }
        }
        else
        {
          String[] numtickets = new String[counter];
          int j = 0;
          for (int i = 0; i < numbertickets.length; i++)
          {
            if (!numbertickets[i].equals(""))
            {
              numtickets[j] = numbertickets[i];
              j++;
            }
          }
          session.setAttribute("rideOp", rideOptions);
          session.setAttribute("numberTic", numtickets);

          int totalTickets = 0;
          double totalAmount = 0;
          for (int i = 0; i < numtickets.length; i++)
          {
            totalTickets = totalTickets
              + Integer.parseInt(numtickets[i]);
            totalAmount = totalAmount
              + (Integer.parseInt(numtickets[i])
              * ticketCost[i]);
          }
          session.setAttribute("totalTickets",
            totalTickets);
          session.setAttribute("totalAmount",
            totalAmount);

          ModifyDatabase objModify = new ModifyDatabase();
          objModify.insertCustomer(customerName, ticketDate,
            email, totalAmount, totalTickets);

          int customerId = objDb.getCustomerId();
          for (int r = 0; r < rideOptions.length; r++)
          {
            for (int k = 0; k < Integer.parseInt(numtickets[r]);
              k++)
            {
              objModify.insertTicket(customerId, ticketCost[r],
                ticketDate, rideOptions[r]);
            }
          }
          String myUrl = "/WEB-INF" + userPath + ".jsp";
          try
          {
            // redirect back to new URL with new data
            request.getRequestDispatcher(myUrl).forward(request, response);
          }
          catch (Exception ex)
          {
            request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
          }
        }
      }
    }

    else if (userPath.equals("/insertViewRides"))
    {
      String rideName = request.getParameter("rideName");
      double heightLimit = Double.parseDouble(
        request.getParameter("heightLimit"));
      double price = Double.parseDouble(
        request.getParameter("price"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.insertRide(rideName, heightLimit, price);
      // get updated data to display
      session.setAttribute("rideInfo", getRides());
      session.setAttribute("maintInfo", getMaintenance());
      // URL to go back to
      String myUrl = "/WEB-INF/viewrides.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/deleteViewRides"))
    {
      String rideName = request.getParameter("rideName");
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.deleteRide(rideName);
      // get updated data to display
      session.setAttribute("rideInfo", getRides());
      session.setAttribute("maintInfo", getMaintenance());
      // URL to go back to
      String myUrl = "/WEB-INF/viewrides.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/modifyViewRides"))
    {
      String rideName = request.getParameter("rideName");
      double heightLimit = Double.parseDouble(
        request.getParameter("heightLimit"));
      double price = Double.parseDouble(
        request.getParameter("price"));
      String needsM = request.getParameter("needsM");
      int needsMaintenance = 0;
      if (needsM.charAt(0) == 'Y'
        || needsM.charAt(0) == 'y')
      {
        needsMaintenance = 1;
      }
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.updateRide(rideName, heightLimit,
        needsMaintenance, price);

      // get updated data to display
      session.setAttribute("rideInfo", getRides());
      session.setAttribute("maintInfo", getMaintenance());
      // URL to go back to
      String myUrl = "/WEB-INF/viewrides.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
// need maintenance
    else if (userPath.equals("/requestViewRides"))
    {
      String rideName = request.getParameter("rideName");
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.requestMaintenance(rideName);

      // get updated data to display
      session.setAttribute("rideInfo", getRides());
      session.setAttribute("maintInfo", getMaintenance());
      // URL to go back to
      String myUrl = "/WEB-INF/viewrides.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/deleteViewMaintenance"))
    {
      int orderId = Integer.parseInt(
        request.getParameter("orderId"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.deleteMaintenance(orderId);
      // get updated data to display
      session.setAttribute("rideInfo", getRides());
      session.setAttribute("maintInfo", getMaintenance());
      // URL to go back to
      String myUrl = "/WEB-INF/viewrides.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/modifyViewMaintenance"))
    {
      int orderId = Integer.parseInt(
        request.getParameter("orderId"));
      String tempDate = request.getParameter("mDate");
      ProduceReport objRep = new ProduceReport();
      String mDate = objRep.parseDate(tempDate);
      tempDate = request.getParameter("bDate");
      String bDate = objRep.parseDate(tempDate);
      String isComp = request.getParameter("isComplete");
      int isCompleted = 0;
      if (isComp.charAt(0) == 'Y'
        || isComp.charAt(0) == 'y')
      {
        isCompleted = 1;
      }
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.updateMaintenance(orderId,
        isCompleted, mDate, bDate);
      // get updated data to display
      session.setAttribute("rideInfo", getRides());
      session.setAttribute("maintInfo", getMaintenance());
      // URL to go back to
      String myUrl = "/WEB-INF/viewrides.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/modifyViewMaintenanceRepair"))
    {
      int orderId = Integer.parseInt(
        request.getParameter("orderId"));
      String tempDate = request.getParameter("mDate");
      ProduceReport objRep = new ProduceReport();
      String mDate = objRep.parseDate(tempDate);
      tempDate = request.getParameter("bDate");
      String bDate = objRep.parseDate(tempDate);
      String isComp = request.getParameter("isComplete");
      int isCompleted = 0;
      if (isComp.charAt(0) == 'Y'
        || isComp.charAt(0) == 'y')
      {
        isCompleted = 1;
      }
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.updateMaintenance(orderId,
        isCompleted, mDate, bDate);
      // get updated data to display
      session.setAttribute("rideInfo", getRides());
      session.setAttribute("maintInfo", getMaintenance());
      // URL to go back to
      String myUrl = "/WEB-INF/viewrepairs.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/insertViewCustomers"))
    {
      String customerName
        = request.getParameter("customerName");
      String tempDate
        = request.getParameter("ticketDate");
      ProduceReport objRep = new ProduceReport();
      String ticketDate = objRep.parseDate(tempDate);
      String email
        = request.getParameter("email");

      double orderAmount = Double.parseDouble(
        request.getParameter("orderAmount"));
      int ticketAmount = Integer.parseInt(
        request.getParameter("ticketAmount"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.insertCustomer(customerName, ticketDate,
        email, orderAmount, ticketAmount);
      // get updated data to display
      session.setAttribute("customerInfo",
        getCustomers());
      // URL to go back to
      String myUrl = "/WEB-INF/viewcustomers.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/deleteViewCustomers"))
    {
      int orderId = Integer.parseInt(
        request.getParameter("orderId"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.deleteCustomer(orderId);
      // get updated data to display
      session.setAttribute("customerInfo",
        getCustomers());
      // URL to go back to
      String myUrl = "/WEB-INF/viewcustomers.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/modifyViewCustomers"))
    {
      String customerName
        = request.getParameter("customerName");
      String tempDate
        = request.getParameter("ticketDate");
      ProduceReport objRep = new ProduceReport();
      String ticketDate = objRep.parseDate(tempDate);
      String email
        = request.getParameter("email");
      int orderId = Integer.parseInt(
        request.getParameter("orderId"));
      double orderAmount = Double.parseDouble(
        request.getParameter("orderAmount"));
      int ticketAmount = Integer.parseInt(
        request.getParameter("ticketAmount"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.updateCustomer(customerName, ticketDate,
        email, orderId, orderAmount, ticketAmount);
      // get updated data to display
      session.setAttribute("customerInfo",
        getCustomers());
      // URL to go back to
      String myUrl = "/WEB-INF/viewcustomers.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    // ticket
    else if (userPath.equals("/insertViewTickets"))
    {
      int customerId = Integer.parseInt(
        request.getParameter("customerId"));
      double ridePrice = Double.parseDouble(
        request.getParameter("ridePrice"));
      String tempDate
        = request.getParameter("visitDate");
      ProduceReport objRep = new ProduceReport();
      String visitDate = objRep.parseDate(tempDate);
      String rideN
        = request.getParameter("rideN");
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.insertTicket(customerId, ridePrice,
        visitDate, rideN);
      // get updated data to display
      session.setAttribute("ticketInfo",
        getTickets());
      // URL to go back to
      String myUrl = "/WEB-INF/viewtickets.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/deleteViewTickets"))
    {
      int ticketId = Integer.parseInt(
        request.getParameter("ticketId"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.deleteTicket(ticketId);
      // get updated data to display
      session.setAttribute("ticketInfo",
        getTickets());
      // URL to go back to
      String myUrl = "/WEB-INF/viewtickets.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/modifyViewTickets"))
    {
      int ticketId = Integer.parseInt(
        request.getParameter("ticketId"));
      int customerId = Integer.parseInt(
        request.getParameter("customerId"));
      double ridePrice = Double.parseDouble(
        request.getParameter("ridePrice"));
      String tempDate
        = request.getParameter("visitDate");
      ProduceReport objRep = new ProduceReport();
      String visitDate = objRep.parseDate(tempDate);
      String rideN
        = request.getParameter("rideN");
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.updateTicket(ticketId, customerId,
        ridePrice, visitDate, rideN);
      // get updated data to display
      session.setAttribute("ticketInfo",
        getTickets());
      // URL to go back to
      String myUrl = "/WEB-INF/viewtickets.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    /* employee */
    else if (userPath.equals("/insertViewEmployees"))
    {
      String fName
        = request.getParameter("fName");
      String lName
        = request.getParameter("lName");
      String email
        = request.getParameter("email");
      int empId = Integer.parseInt(
        request.getParameter("empId"));
      String password
        = request.getParameter("password");
      String tempDate = request.getParameter("birthDate");
      ProduceReport objRep = new ProduceReport();
      String birthDate = objRep.parseDate(tempDate);
      String gender
        = request.getParameter("gender");
      String ssn
        = request.getParameter("ssn");
      double salary = Double.parseDouble(
        request.getParameter("salary"));
      String position
        = request.getParameter("position");
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.insertEmployee(fName, lName, email, empId,
        password, birthDate, gender, ssn, salary, position);

      // get updated data to display
      session.setAttribute("employeeInfo",
        getEmployees());
      // URL to go back to
      String myUrl = "/WEB-INF/viewemployees.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/deleteViewEmployees"))
    {
      int empId = Integer.parseInt(
        request.getParameter("empId"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.deleteEmployee(empId);
      // get updated data to display
      session.setAttribute("employeeInfo",
        getEmployees());
      // URL to go back to
      String myUrl = "/WEB-INF/viewemployees.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/modifyViewEmployees"))
    {
      String fName
        = request.getParameter("fName");
      String lName
        = request.getParameter("lName");
      String email
        = request.getParameter("email");
      int empId = Integer.parseInt(
        request.getParameter("empId"));
      String password
        = request.getParameter("password");
      String tempDate
        = request.getParameter("birthDate");
      ProduceReport objRep = new ProduceReport();
      String birthDate = objRep.parseDate(tempDate);
      String gender
        = request.getParameter("gender");
      String ssn
        = request.getParameter("ssn");
      double salary = Double.parseDouble(
        request.getParameter("salary"));
      String position
        = request.getParameter("position");
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.updateEmployee(fName, lName, email, empId,
        password, birthDate, gender, ssn, salary, position);

      // get updated data to display
      session.setAttribute("employeeInfo",
        getEmployees());
      // URL to go back to
      String myUrl = "/WEB-INF/viewemployees.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
// Restaurants
    else if (userPath.equals("/insertViewRestaurants"))
    {
      String name = request.getParameter("name");
      int managerId = Integer.parseInt(
        request.getParameter("managerId"));
      int restaurantId = Integer.parseInt(
        request.getParameter("restaurantId"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.insertRestaurant(name, managerId, restaurantId);

      // get updated data to display
      session.setAttribute("restaurantInfo",
        getRestaurants());
      // URL to go back to
      String myUrl = "/WEB-INF/viewrestaurants.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/deleteViewRestaurants"))
    {
      int restaurantId = Integer.parseInt(
        request.getParameter("restaurantId"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.deleteRestaurant(restaurantId);

      // get updated data to display
      session.setAttribute("restaurantInfo",
        getRestaurants());
      // URL to go back to
      String myUrl = "/WEB-INF/viewrestaurants.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/modifyViewRestaurants"))
    {
      String name = request.getParameter("name");
      int managerId = Integer.parseInt(
        request.getParameter("managerId"));
      int restaurantId = Integer.parseInt(
        request.getParameter("restaurantId"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.updateRestaurant(name, managerId, restaurantId);

      // get updated data to display
      session.setAttribute("restaurantInfo",
        getRestaurants());
      // URL to go back to
      String myUrl = "/WEB-INF/viewrestaurants.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
// Gift shops
    else if (userPath.equals("/insertViewGiftShops"))
    {
      int empId = Integer.parseInt(
        request.getParameter("empId"));
      int shopId = Integer.parseInt(
        request.getParameter("shopId"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.insertGiftShop(empId, shopId);

      ArrayList<ArrayList<String>> dataCa = getCarnival();
      session.setAttribute("gameInfo", dataCa);
      ArrayList<ArrayList<String>> dataGs = getGiftShop();
      //session.setAttribute("giftShopInfo", dataGs);
      ArrayList<ArrayList<String>> dataG = getGifts();

      joinGiftShop(dataGs, dataG);
      session.setAttribute("giftInfo", dataG);
      // URL to go back to
      String myUrl = "/WEB-INF/viewgames.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/deleteViewGiftShops"))
    {
      int shopId = Integer.parseInt(
        request.getParameter("shopId"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.deleteGiftShop(shopId);

      ArrayList<ArrayList<String>> dataCa = getCarnival();
      session.setAttribute("gameInfo", dataCa);
      ArrayList<ArrayList<String>> dataGs = getGiftShop();
      //session.setAttribute("giftShopInfo", dataGs);
      ArrayList<ArrayList<String>> dataG = getGifts();

      joinGiftShop(dataGs, dataG);
      session.setAttribute("giftInfo", dataG);
      // URL to go back to
      String myUrl = "/WEB-INF/viewgames.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
// gift
    else if (userPath.equals("/insertViewGifts"))
    {
      int giftId = Integer.parseInt(
        request.getParameter("giftId"));
      int storeId = Integer.parseInt(
        request.getParameter("storeId"));
      double price = Double.parseDouble(
        request.getParameter("price"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.insertGift(giftId, storeId, price);

      ArrayList<ArrayList<String>> dataCa = getCarnival();
      session.setAttribute("gameInfo", dataCa);
      ArrayList<ArrayList<String>> dataGs = getGiftShop();
      //session.setAttribute("giftShopInfo", dataGs);
      ArrayList<ArrayList<String>> dataG = getGifts();

      joinGiftShop(dataGs, dataG);
      session.setAttribute("giftInfo", dataG);
      // URL to go back to
      String myUrl = "/WEB-INF/viewgames.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/deleteViewGifts"))
    {
      int giftId = Integer.parseInt(
        request.getParameter("giftId"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.deleteGift(giftId);

      ArrayList<ArrayList<String>> dataCa = getCarnival();
      session.setAttribute("gameInfo", dataCa);
      ArrayList<ArrayList<String>> dataGs = getGiftShop();
      //session.setAttribute("giftShopInfo", dataGs);
      ArrayList<ArrayList<String>> dataG = getGifts();

      joinGiftShop(dataGs, dataG);
      session.setAttribute("giftInfo", dataG);
      // URL to go back to
      String myUrl = "/WEB-INF/viewgames.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
//game
    else if (userPath.equals("/insertViewGames"))
    {
      int gameId = Integer.parseInt(
        request.getParameter("gameId"));
      int shopId = Integer.parseInt(
        request.getParameter("empId"));
      String attraction = request.getParameter("attraction");
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.insertGame(gameId, shopId, attraction);

      ArrayList<ArrayList<String>> dataCa = getCarnival();
      session.setAttribute("gameInfo", dataCa);
      ArrayList<ArrayList<String>> dataGs = getGiftShop();
      //session.setAttribute("giftShopInfo", dataGs);
      ArrayList<ArrayList<String>> dataG = getGifts();

      joinGiftShop(dataGs, dataG);
      session.setAttribute("giftInfo", dataG);
      // URL to go back to
      String myUrl = "/WEB-INF/viewgames.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }

    else if (userPath.equals("/deleteViewGames"))
    {
      int gameId = Integer.parseInt(
        request.getParameter("gameId"));
      ModifyDatabase objModify = new ModifyDatabase();
      objModify.deleteGame(gameId);

      ArrayList<ArrayList<String>> dataCa = getCarnival();
      session.setAttribute("gameInfo", dataCa);
      ArrayList<ArrayList<String>> dataGs = getGiftShop();
      //session.setAttribute("giftShopInfo", dataGs);
      ArrayList<ArrayList<String>> dataG = getGifts();

      joinGiftShop(dataGs, dataG);
      session.setAttribute("giftInfo", dataG);
      // URL to go back to
      String myUrl = "/WEB-INF/viewgames.jsp";
      try
      {
        // redirect back to new URL with new data
        request.getRequestDispatcher(myUrl).forward(request, response);
      }
      catch (Exception ex)
      {
        request.getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
      }
    }
    processRequest(request, response);
  }
// In purchase ticket, it checks if 
// rides are selected correctly

  public boolean checkOptions(String[] rideOptions,
                              String[] numberTickets)
  {
    if (rideOptions == null)
    {
      return false;
    }
    else
    {
      int numRides = rideOptions.length;
      int numChoices = 0;
      for (int i = 0; i < numberTickets.length; i++)
      {
        if (!numberTickets[i].equals(""))
        {
          numChoices++;
        }
      }
      if (numRides < numChoices)
      {
        return false;
      }
    }
    return true;
  }

  public void joinGiftShop(
    ArrayList<ArrayList<String>> shopData,
    ArrayList<ArrayList<String>> giftData)
  {

    boolean found = false;
    for (int i = 0; i < giftData.size(); i++)
    {
      String shopId = giftData.get(i).get(1);
      found = false;
      for (int j = 0; j < shopData.size() && !found; j++)
      {
        if (shopData.get(j).get(1).equals(shopId))
        {
          found = true;
          String empId = shopData.get(j).get(0);
          giftData.get(i).add(empId);
        }
      }
      if (!found)
      {
        giftData.get(i).add("9999");
      }
    }
  }

  public ArrayList<ArrayList<String>> getRides()
  {
    // db info
    String dbName = "Theme_Park";
    String tableName = "Ride";
    String[] columnNames =
    {
      "Ride_Name", "HeightLimit", "NeedsMaintenance", "Price"
    };
    JavaDatabase objDb = new JavaDatabase(dbName);
    return objDb.getData(tableName, columnNames);
  }

  public ArrayList<ArrayList<String>> getMaintenance()
  {
    String dbName = "Theme_Park";
    String tableName = "Maintenance";
    String[] columnNames =
    {
      "WorkOrderID", "IsCompleted", "BreakdownDate",
      "R_Name", "MaintenanceDate"
    };
    JavaDatabase objDb = new JavaDatabase(dbName);
    return objDb.getData(tableName,
      columnNames);
  }

  public ArrayList<ArrayList<String>> getTickets()
  {
    // db info
    String dbName = "Theme_Park";
    String tableName = "Ticket";
    String[] columnNames =
    {
      "TicketID", "Customer_ID", "RidePrice",
      "VisitDate", "Ride_N"
    };
    JavaDatabase objDb = new JavaDatabase(dbName);
    return objDb.getData(tableName, columnNames);
  }

  public ArrayList<ArrayList<String>> getCustomers()
  {
    // db info
    String dbName = "Theme_Park";
    String tableName = "Customer_Order";
    String[] columnNames =
    {
      "Name", "Ticket_Date", "Email", "OrderID",
      "OrderTotal", "TicketAmount"
    };
    JavaDatabase objDb = new JavaDatabase(dbName);
    return objDb.getData(tableName, columnNames);
  }

  public ArrayList<ArrayList<String>> getEmployees()
  {
    // db info
    String dbName = "Theme_Park";
    String tableName = "Employee";
    String[] columnNames =
    {
      "FName", "MNAME", "LName", "Email", "Emp_ID", "Password",
      "Birth_Date", "Sex", "SSN", "Salary", "Position"
    };
    JavaDatabase objDb = new JavaDatabase(dbName);
    return objDb.getData(tableName, columnNames);
  }

  public ArrayList<ArrayList<String>> getRestaurants()
  {
    // db info
    String dbName = "Theme_Park";
    String tableName = "Restaurant";
    String[] columnNames =
    {
      "Name", "Manager_ID", "RestaurantID"
    };
    JavaDatabase objDb = new JavaDatabase(dbName);
    return objDb.getData(tableName, columnNames);
  }

  public ArrayList<ArrayList<String>> getGiftShop()
  {
    // db info
    String dbName = "Theme_Park";
    String tableName = "Gift_Shop";
    String[] columnNames =
    {
      "Employee_ID", "Shop_ID"
    };
    JavaDatabase objDb = new JavaDatabase(dbName);
    return objDb.getData(tableName, columnNames);
  }

  public ArrayList<ArrayList<String>> getGifts()
  {
    // db info
    String dbName = "Theme_Park";
    String tableName = "Gifts";
    String[] columnNames =
    {
      "GiftID", "Store_ID", "Price"
    };
    JavaDatabase objDb = new JavaDatabase(dbName);
    return objDb.getData(tableName, columnNames);
  }

  public ArrayList<ArrayList<String>> getCarnival()
  {
    // db info
    String dbName = "Theme_Park";
    String tableName = "CarnivalAttraction";
    String[] columnNames =
    {
      "GameID", "E_ID", "Attraction"
    };
    JavaDatabase objDb = new JavaDatabase(dbName);
    return objDb.getData(tableName, columnNames);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo()
  {
    return "Short description";
  }// </editor-fold>

}
