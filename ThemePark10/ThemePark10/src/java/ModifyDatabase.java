// Ariya Ansari

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModifyDatabase
{

  public void insertRide(String rideName, double heightLimit, 
                                          double price)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery = "INSERT INTO Ride VALUES (?,?,?,?)";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setString(1, rideName);
      ps.setDouble(2, heightLimit);
      ps.setInt(3, 0);
      ps.setDouble(4, price);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data inserted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error inserting data");
    }
    objDb.closeDbConn();
  }

  public void deleteRide(String rideName)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery
      = "DELETE FROM Ride WHERE Ride_Name = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setString(1, rideName);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data deleted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error deleting data");
    }
    objDb.closeDbConn();
  }

  public void updateRide(String rideName, double heightLimit,
                         int needM, double price)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery
      = "UPDATE Ride SET HeightLimit = ?, NeedsMaintenance = ?, "
      + " Price = ? WHERE Ride_Name = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setDouble(1, heightLimit);
      ps.setInt(2, needM);
      ps.setDouble(3, price);
      ps.setString(4, rideName);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data updated successfully");
      if (needM == 1)
      {
        fixDate(rideName, objDb, myDbConn);
      }
    }
    catch (SQLException se)
    {
      System.out.println("Error updating data");
    }
    objDb.closeDbConn();
  }

  public void requestMaintenance(String rideName)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery
      = "UPDATE Ride SET NeedsMaintenance = 1 "
      + " WHERE Ride_Name = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setString(1, rideName);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data updated successfully");
      fixDate(rideName, objDb, myDbConn);
    }
    catch (SQLException se)
    {
      System.out.println("Error updating data");
    }
    objDb.closeDbConn();
  }
  
  public void fixDate(String rideName, JavaDatabase objDb,
                      Connection myDbConn)
  {

    // connect to db
    // insert into Database
    ResultSet rs = null;
    String dbQuery1 = "SELECT BreakdownDate FROM Maintenance "
      + " WHERE R_Name = ? AND MaintenanceDate = 'unknown' ";
    ArrayList<String> sqlDate = new ArrayList<>();
    // read the data
    try
    {
      // prepare statement
      PreparedStatement ps1 = myDbConn.prepareStatement(dbQuery1);
      // enter data into query
      ps1.setString(1, rideName);
      // execute the query
      rs = ps1.executeQuery();
      while (rs.next())
      {
        String cell = rs.getString("BreakdownDate");
        if (cell.charAt(4) == '-'
          && cell.charAt(7) == '-'
          && cell.charAt(0) != '-'
          && cell.charAt(1) != '-'
          && cell.charAt(2) != '-')
        {
          sqlDate.add(cell);
        }
      }
      for (int i = 0; i < sqlDate.size(); i++)
      {
        String newDate = formatSqlDate(sqlDate.get(i));
        String dbQuery2
          = "UPDATE Maintenance SET BreakdownDate = ? "
          + "WHERE R_Name = ? AND BreakdownDate = ? ";
        try
        {
          // prepare statement
          PreparedStatement ps2 = myDbConn.prepareStatement(dbQuery2);

          // enter data into query
          ps2.setString(1, newDate);
          ps2.setString(2, rideName);
          ps2.setString(3, sqlDate.get(i));
          // execute the query
          ps2.executeUpdate();
          System.out.println("Data updated successfully");
        }
        catch (SQLException se)
        {
          System.out.println("Error updating data");
        }
      }
    }
    catch (SQLException se)
    {
      System.out.println("unable to get data");
    }
  }

  public String formatSqlDate(String euroDate)
  {
    String amDate;
    if (euroDate.charAt(4) != '-')
    {
      return euroDate;
    }
    else
    {
      amDate = euroDate.substring(5, 7);
      amDate = amDate + euroDate.substring(7);
      amDate = amDate + "-";
      amDate = amDate + euroDate.substring(0, 4);
      return amDate;
    }
  }

  public void deleteMaintenance(int id)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery
      = "DELETE FROM Maintenance WHERE WorkOrderID = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setInt(1, id);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data deleted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error deleting data");
    }
    objDb.closeDbConn();
  }

  public void updateMaintenance(int id, int isComplete,
                                String maintenanceDate, String breakdownDate)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery
      = "UPDATE Maintenance SET isCompleted = ?, "
      + " MaintenanceDate = ?, BreakdownDate = ? "
      + "WHERE WorkOrderID = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setInt(4, id);
      ps.setInt(1, isComplete);
      ps.setString(2, maintenanceDate);
      ps.setString(3, breakdownDate);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data updated successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error updating data");
    }
    objDb.closeDbConn();
  }

  public void insertTicket(int customerId, 
       double ridePrice, String visitDate, String rideN)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery = "INSERT INTO Ticket " 
      + "(Customer_ID, RidePrice, VisitDate, Ride_N)"
      + " VALUES (?,?,?,?)";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps
        = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setInt(1, customerId);
      ps.setDouble(2, ridePrice);
      ps.setString(3, visitDate);
      ps.setString(4, rideN);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data inserted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error inserting data");
    }
    objDb.closeDbConn();
  }
 
  public void updateTicket(
    int ticketId, int customerId, double ridePrice, 
    String visitDate, String rideN)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery = "UPDATE Ticket SET "
      + "Customer_ID = ?, RidePrice = ?, VisitDate = ?, "
      + "Ride_N = ? WHERE TicketID = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps
        = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setInt(1, customerId);
      ps.setDouble(2, ridePrice);
      ps.setString(3, visitDate);
      ps.setString(4, rideN);
      ps.setInt(5, ticketId);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data updated successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error updating data");
    }
    objDb.closeDbConn();
  }

  public void deleteTicket(int ticketId)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery
      = "DELETE FROM Ticket WHERE TicketID = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setInt(1, ticketId);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data deleted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error deleting data");
    }
    objDb.closeDbConn();
  }
  
  public void insertCustomer(
    String customerName, String ticketDate, String email,
    double orderTotal, int ticketAmount)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery = "INSERT INTO Customer_Order "
      + "(Name, Ticket_Date, Email, OrderTotal, TicketAmount)"
      + " VALUES (?,?,?,?,?)";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps
        = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setString(1, customerName);
      ps.setString(2, ticketDate);
      ps.setString(3, email);
      ps.setDouble(4, orderTotal);
      ps.setInt(5, ticketAmount);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data inserted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error inserting data");
    }
    objDb.closeDbConn();
  }

  public void updateCustomer(
    String customerName, String ticketDate, String email,
    int orderId, double orderTotal, int ticketAmount)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery = "UPDATE Customer_Order SET "
      + "Name = ?, Ticket_Date = ?, "
      + "Email = ?, OrderTotal = ?, "
      + "TicketAmount = ? WHERE OrderID = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps
        = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setString(1, customerName);
      ps.setString(2, ticketDate);
      ps.setString(3, email);
      ps.setInt(6, orderId);
      ps.setDouble(4, orderTotal);
      ps.setInt(5, ticketAmount);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data updated successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error updating data");
    }
    objDb.closeDbConn();
  }

  public void deleteCustomer(int orderId)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery
      = "DELETE FROM Customer_Order WHERE OrderID = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setInt(1, orderId);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data deleted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error deleting data");
    }
    objDb.closeDbConn();
  }
  
  
// Employee

  public void insertEmployee(
    String fName, String lName, String email,
    int empId, String password, String birthDate,
    String sex, String ssn, double salary, String position)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery = "INSERT INTO Employee "
      + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps
        = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setString(1, fName);
      ps.setString(2, " ");
      ps.setString(3, lName);
      ps.setString(4, email);
      ps.setInt(5, empId);
      ps.setString(6, password);
      ps.setString(7, birthDate);
      ps.setString(8, sex);
      ps.setString(9, ssn);
      ps.setDouble(10, salary);
      ps.setString(11, position);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data inserted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error inserting data");
    }
    objDb.closeDbConn();
  }

  public void updateEmployee(
    String fName, String lName, String email,
    int empId, String password, String birthDate,
    String sex, String ssn, double salary, String position)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery = "UPDATE Employee SET "
      + "FName = ?, MName = ?, LName = ?, Email = ?,  "
      + "Password = ?, Birth_Date = ?, Sex = ?, SSN = ?, "
      + "Salary = ?, Position = ? WHERE Emp_ID = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps
        = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setString(1, fName);
      ps.setString(2, " ");
      ps.setString(3, lName);
      ps.setString(4, email);
      ps.setInt(11, empId);
      ps.setString(5, password);
      ps.setString(6, birthDate);
      ps.setString(7, sex);
      ps.setString(8, ssn);
      ps.setDouble(9, salary);
      ps.setString(10, position);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data updated successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error updating data");
    }
    objDb.closeDbConn();
  }

  public void deleteEmployee(int empId)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery
      = "DELETE FROM Employee WHERE Emp_ID = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setInt(1, empId);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data deleted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error deleting data");
    }
    objDb.closeDbConn();
  }

  public void insertRestaurant(String name, int managerId,
                               int restaurantId)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery = "INSERT INTO Restaurant VALUES (?,?,?)";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setString(1, name);
      ps.setInt(2, managerId);
      ps.setInt(3, restaurantId);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data inserted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error inserting data");
    }
    objDb.closeDbConn();
  }

  public void deleteRestaurant(int restaurantId)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery
      = "DELETE FROM Restaurant WHERE RestaurantID = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setInt(1, restaurantId);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data deleted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error deleting data");
    }
    objDb.closeDbConn();
  }

  public void updateRestaurant(String name, int managerId,
                               int restaurantId)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery = "UPDATE Restaurant SET "
      + "Name = ?, Manager_ID = ? WHERE RestaurantID = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setString(1, name);
      ps.setInt(2, managerId);
      ps.setInt(3, restaurantId);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data updated successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error updating data");
    }
    objDb.closeDbConn();
  }

  public void insertGiftShop(int empId,
                             int shopId)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery = "INSERT INTO Gift_Shop VALUES (?,?)";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setInt(1, empId);
      ps.setInt(2, shopId);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data inserted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error inserting data");
    }
    objDb.closeDbConn();
  }

  public void deleteGiftShop(int shopId)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery
      = "DELETE FROM Gift_Shop WHERE Shop_ID = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setInt(1, shopId);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data deleted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error deleting data");
    }
    objDb.closeDbConn();
  }

  public void insertGift(int giftId, int storeId, double price)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery = "INSERT INTO Gifts VALUES (?,?,?)";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setInt(1, giftId);
      ps.setInt(2, storeId);
      ps.setDouble(3, price);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data inserted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error inserting data");
    }
    objDb.closeDbConn();
  }

  public void deleteGift(int giftId)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery
      = "DELETE FROM Gifts WHERE GiftID = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setInt(1, giftId);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data deleted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error deleting data");
    }
    objDb.closeDbConn();
  }

  public void insertGame(int gameId, int empId,
                         String attraction)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery = "INSERT INTO CarnivalAttraction VALUES (?,?,?)";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setInt(1, gameId);
      ps.setInt(2, empId);
      ps.setString(3, attraction);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data inserted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error inserting data");
    }
    objDb.closeDbConn();
  }

  public void deleteGame(int gameId)
  {
    String dbName = "Theme_Park";
    // insert query
    String dbQuery
      = "DELETE FROM CarnivalAttraction WHERE GameID = ?";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();
    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setInt(1, gameId);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data deleted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error deleting data");
    }
    objDb.closeDbConn();
  }
  
  

  public static void main(String[] args)
  {
    //ModifyDatabase objModify = new ModifyDatabase();
//    objModify.updateMaintenance("Roller Coaster", 9567,
//                      0, "4-10-2023");

  }
}
