// Ariya Ansari

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JavaDatabase
{

  private String dbName;
  private Connection dbConn;
  private ArrayList<ArrayList<String>> data;

  public JavaDatabase()
  {
    dbName = "";
    dbConn = null;
    data = null;
  }

  public JavaDatabase(String dbName)
  {
    setDbName(dbName);
    setDbConn();
    data = null;
  }

  public String getDbName()
  {
    return dbName;
  }

  public void setDbName(String dbName)
  {
    this.dbName = dbName;
  }

  public Connection getDbConn()
  {
    return dbConn;
  }

  public void setDbConn()
  {
    String connectionURL = "jdbc:mysql://localhost:3306/"
      + this.dbName + "?autoReconnect=true&useSSL=false";
    this.dbConn = null;
    try
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
      this.dbConn = DriverManager.getConnection(connectionURL,
        "root", "mysql1");
    }
    catch (ClassNotFoundException ex)
    {
      System.out.println("Driver not found, check library");
    }
    catch (SQLException err)
    {
      System.out.println("SQL Connection error.");
    }
  }

  public ArrayList<ArrayList<String>> getData(String tableName,
                                              String[] tableHeaders)
  {
    int columnCount = tableHeaders.length;
    Statement s = null;
    ResultSet rs = null;
    String dbQuery = "SELECT * FROM " + tableName;
    this.data = new ArrayList<>();
    // read the data
    try
    {
      // send the query and receive data
      s = this.dbConn.createStatement();
      rs = s.executeQuery(dbQuery);

      // read the data using rs and store in ArrayList data        
      while (rs.next())
      {
        // row object to hold one row data
        ArrayList<String> row = new ArrayList<>();
        // go through the row and read each cell
        for (int i = 0; i < columnCount; i++)
        {
          // read cell i
          // example: String cell = rs.getString("Name");
          // reads the cell in column Name
          // tableHeader={"Name", "Age", "Color"}
          String cell = rs.getString(tableHeaders[i]);
          // add the cell to the row
          // example row.add("Vinny");
          row.add(cell);
        }
        // add the row to the data
        // example: data.add "Vinny",15,"Pink"
        this.data.add(row);
      }
    }
    catch (SQLException se)
    {
      System.out.println("SQL Error: Not able to get data");
    }
    return data;
  }

  public ArrayList<ArrayList<String>> getRideAndPrice()
  {
    Statement s = null;
    ResultSet rs = null;
    String dbQuery = "SELECT Ride_Name, Price FROM Ride";
    ArrayList<ArrayList<String>> rideData = new ArrayList<>();
    // read the data
    try
    {
      // send the query and receive data
      s = this.dbConn.createStatement();
      rs = s.executeQuery(dbQuery);

      // read the data using rs and store in ArrayList data        
      while (rs.next())
      {
        // row object to hold one row data
        ArrayList<String> row = new ArrayList<>();
        String cell = rs.getString("Ride_Name");
        row.add(cell);
        cell = rs.getString("Price");
        row.add(cell);
        rideData.add(row);
      }
    }
    catch (SQLException se)
    {
      System.out.println("SQL Error: Not able to get data");
    }
    return rideData;
  }

  public int getCustomerCount()
  {
    int counter = 0;
    Statement s = null;
    ResultSet rs = null;

    String dbQuery
      = "SELECT COUNT(*) AS Counter FROM Customer_Order";
    // read the data
    try
    {
      // send the query and receive data
      s = this.dbConn.createStatement();
      rs = s.executeQuery(dbQuery);
      // read the data using rs and store in ArrayList data        
      if (rs.next());
      counter = rs.getInt("Counter");
    }
    catch (SQLException se)
    {
      System.out.println("SQL Error: Not able to get data");
    }
    return counter;
  }

  public int getRideCount()
  {
    int counter = 0;
    Statement s = null;
    ResultSet rs = null;

    String dbQuery
      = "SELECT COUNT(*) AS Counter FROM Ride";
    // read the data
    try
    {
      // send the query and receive data
      s = this.dbConn.createStatement();
      rs = s.executeQuery(dbQuery);
      // read the data using rs and store in ArrayList data        
      if (rs.next());
      counter = rs.getInt("Counter");
    }
    catch (SQLException se)
    {
      System.out.println("SQL Error: Not able to get data");
    }
    return counter;
  }

  public int getBrokenRideCount()
  {
    int counter = 0;
    Statement s = null;
    ResultSet rs = null;

    String dbQuery
      = "SELECT COUNT(*) AS Counter FROM Ride WHERE "
      + " NeedsMaintenance = 1";
    // read the data
    try
    {
      // send the query and receive data
      s = this.dbConn.createStatement();
      rs = s.executeQuery(dbQuery);
      // read the data using rs and store in ArrayList data        
      if (rs.next());
      counter = rs.getInt("Counter");
    }
    catch (SQLException se)
    {
      System.out.println("SQL Error: Not able to get data");
    }
    return counter;
  }

  public ArrayList<String> getTicketDates()
  {

    Statement s = null;
    ResultSet rs = null;
    String dbQuery = "SELECT (Ticket_Date) FROM Customer_Order";
    ArrayList<String> ticketDate = new ArrayList<>();
    // read the data
    try
    {
      // send the query and receive data
      s = this.dbConn.createStatement();
      rs = s.executeQuery(dbQuery);

      // read the data using rs and store in ArrayList data        
      while (rs.next())
      {
        String cell = rs.getString("Ticket_Date");
        ticketDate.add(cell);
      }
    }
    catch (SQLException se)
    {
      System.out.println("SQL Error: Not able to get data");
    }
    return ticketDate;
  }

  public ArrayList<String> getRideNames()
  {
    Statement s = null;
    ResultSet rs = null;
    String dbQuery = "SELECT Ride_Name FROM Ride";
    ArrayList<String> rideData = new ArrayList<>();
    // read the data
    try
    {
      // send the query and receive data
      s = this.dbConn.createStatement();
      rs = s.executeQuery(dbQuery);
      // read the data using rs and store in ArrayList data        
      while (rs.next())
      {
        String cell = rs.getString("Ride_Name");
        rideData.add(cell);
      }
    }
    catch (SQLException se)
    {
      System.out.println("SQL Error: Not able to get data");
    }
    return rideData;
  }

  public ArrayList<Double> getRidePrices()
  {
    Statement s = null;
    ResultSet rs = null;
    String dbQuery = "SELECT Price FROM Ride";
    ArrayList<Double> priceData = new ArrayList<>();
    // read the data
    try
    {
      // send the query and receive data
      s = this.dbConn.createStatement();
      rs = s.executeQuery(dbQuery);
      // read the data using rs and store in ArrayList data        
      while (rs.next())
      {
        double cell = rs.getDouble("Price");
        priceData.add(cell);
      }
    }
    catch (SQLException se)
    {
      System.out.println("SQL Error: Not able to get data");
    }
    return priceData;
  }

  //SELECT MAX(OrderID) AS LargestID FROM Customer_Order;
  public int getCustomerId()
  {
    int maxId = 0;
    Statement s = null;
    ResultSet rs = null;

    String dbQuery
      = "SELECT MAX(OrderID) AS LargestID FROM Customer_Order";
    // read the data
    try
    {
      // send the query and receive data
      s = this.dbConn.createStatement();
      rs = s.executeQuery(dbQuery);
      // read the data using rs and store in ArrayList data        
      if (rs.next());
      maxId = rs.getInt("LargestID");
    }
    catch (SQLException se)
    {
      System.out.println("SQL Error: Not able to get data");
    }
    return maxId;
  }

  public void setData(ArrayList<ArrayList<String>> data)
  {
    this.data = data;
  }

  public void createDb(String newDbName)
  {
    setDbName(newDbName);
    Connection newConn;
    String connectionURL = "jdbc:mysql://localhost:3306/";
    String query = "CREATE DATABASE " + this.dbName;
    try
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
      newConn = DriverManager.getConnection(connectionURL, "root", "mysql1");
      Statement s = newConn.createStatement();
      s.executeUpdate(query);
      System.out.println("New database created.");
      newConn.close();
    }
    catch (ClassNotFoundException ex)
    {
      System.out.println("Driver not found, check library");
    }
    catch (SQLException se)
    {
      System.out.println("SQL Connection error, Db was not created!");
    }
  }

  public void createTable(String newTable, String dbName)
  {
    System.out.println(newTable);
    setDbName(dbName);
    setDbConn();
    Statement s;
    try
    {
      s = this.dbConn.createStatement();
      s.execute(newTable);
      System.out.println("New table created.");
      this.dbConn.close();
    }
    catch (SQLException err)
    {
      System.out.println("Error creating table " + newTable);
    }
  }
// to conver a 2d arraylist to 2d array:

  public Object[][] to2dArray(ArrayList<ArrayList<String>> data)
  {
    if (data.size() == 0)
    {
      Object[][] dataList = new Object[0][0];
      return dataList;
    }
    else
    {
      int columnCount = data.get(0).size();
      Object[][] dataList = new Object[data.size()][columnCount];
      for (int i = 0; i < data.size(); i++)
      {
        ArrayList<String> row = data.get(i);
        for (int j = 0; j < columnCount; j++)
        {
          dataList[i][j] = row.get(j);
        }
      }
      return dataList;
    }
  }

  public void closeDbConn()
  {
    try
    {
      this.dbConn.close();
    }
    catch (Exception err)
    {
      System.out.println("DB closing error.");
    }
  }

  public String[] validate(String dbName,
                           String tableName,
                           String userName,
                           String password)
  {
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    String dbQuery = "SELECT * FROM " + tableName
      + " WHERE Emp_ID=? AND Password=?";
    boolean status = false;
    String cell = "null";
    String[] loginData = new String[2];
    try
    {
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      ps.setString(1, userName);
      ps.setString(2, password);
      ResultSet rs = ps.executeQuery();
      status = rs.next();
      if (status)
      {
        cell = rs.getString("Position");
        loginData[0] = "true";
      }
      else
      {
        loginData[0] = "false";
      }
      loginData[1] = cell;
      myDbConn.close();
    }
    catch (SQLException se)
    {
      System.out.println("Sql validate error!");
    }
    return loginData;
  }

  public static void main(String[] args)
  {
    String dbName = "Theme_Park";
    JavaDatabase objDb = new JavaDatabase(dbName);
    System.out.println(objDb.getRideAndPrice());
//    System.out.println(objDb.getBrokenRideCount());
  }

  public static void main3(String[] args)
  {
    String name = "21368999";
    String password = "456";
    // db info
    String dbName = "Theme_Park";
    String tableName = "Employee";

    JavaDatabase objDb = new JavaDatabase(dbName);
    String[] loginData = objDb.validate(dbName, tableName,
      name, password);
    System.out.println(loginData[0]);
    System.out.println(loginData[1]);
  }

  public static void main2(String[] args)
  {
    // db info
    String dbName = "Web1";
    String tableName = "Cars";
    String[] columnNames =
    {
      "name", "price", "color"
    };
    // insert query
    String dbQuery = "INSERT INTO Cars VALUES (?,?,?)";
    // connect to db
    JavaDatabase objDb = new JavaDatabase(dbName);
    Connection myDbConn = objDb.getDbConn();

    // read the data
    String readName = "RollsRoyce";
    int readPrice = 100;
    String readColor = "Blue";

    // insert into Database
    try
    {
      // prepare statement
      PreparedStatement ps = myDbConn.prepareStatement(dbQuery);
      // enter data into query
      ps.setString(1, readName);
      ps.setInt(2, readPrice);
      ps.setString(3, readColor);
      // execute the query
      ps.executeUpdate();
      System.out.println("Data inserted successfully");
    }
    catch (SQLException se)
    {
      System.out.println("Error inserting data");
    }
    ArrayList<ArrayList<String>> data
      = objDb.getData(tableName, columnNames);
    System.out.println(data);
  }
}
