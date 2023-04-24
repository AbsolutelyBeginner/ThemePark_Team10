// Ariya Ansari

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ProduceReport
{

  public static void main(String[] args)
  {
    ProduceReport objR = new ProduceReport();
    System.out.println(objR.parseDate("10-2023-23"));
//    Format f = new SimpleDateFormat("MM-dd-yyyy");
//    String curDate = f.format(new Date());
//    System.out.println("Current Date = " + curDate);
//    ArrayList<String> rides = new ArrayList<>();
//    rides.add("train");
//    rides.add("car");
//    rides.add("car");
//    rides.add("train");
//    rides.add("joe");
//    rides.add("wagon");
//    System.out.println(objR.findMax(rides));
  }

  public ArrayList<ArrayList<String>> ridesReport(
    ArrayList<ArrayList<String>> data,
    String targetYear)
  {
    int ridesTotal = 0;
    int maxMonth = 12;
    ArrayList<String> rideNames = new ArrayList<>();
    ArrayList<String> summaryMonth = new ArrayList<>();
    ArrayList<String> row;
    ArrayList<ArrayList<String>> reportInfo = new ArrayList<>();
    // current date
    Format f = new SimpleDateFormat("MM-dd-yyyy");
    String curDate = f.format(new Date());
    String[] arrDate = curDate.split("-");
    // if the target year is current year, stop at current month
    if (targetYear.equals(arrDate[2]))
    {
      maxMonth = Integer.parseInt(arrDate[0]);
    }
    //go thru each month
    for (int m = 1; m <= maxMonth; m++)
    {
      int monthTotal = 0;
      String month1 = Integer.toString(m);
      String month2;
      if (m < 10)
      {
        month2 = "0" + month1;
      }
      else
      {
        month2 = month1;
      }
      for (int r = 0; r < data.size(); r++)
      {
        String cDate = data.get(r).get(3);
        cDate = parseDate(cDate);
        String cYear = parseYearStr(cDate);
        if (cYear.equals(targetYear))
        {
          String cMonth = parseMonthStr(cDate);
          if (cMonth.equals(month1)
            || cMonth.equals(month2))
          {
            rideNames.add(data.get(r).get(4));
            monthTotal++;
          }
        }
      }
      summaryMonth = findMax(rideNames);
      ridesTotal = ridesTotal + monthTotal;
      // add equivalent month name and total to the row
      row = new ArrayList<>();
      row.add(convertMonth(month1));
      row.add(summaryMonth.get(0));
      row.add(summaryMonth.get(1));
      reportInfo.add(row);
    }
    // add average per month to the list
    row = new ArrayList<>();

    row.add(
      "Average # of Rides Ridden per Month: ");
    double average = (double) ridesTotal / maxMonth;
    average = average * 100;
    average = Math.round(average);
    average = average / 100;

    row.add(Double.toString(average));
    reportInfo.add(row);
    // add total customers to the list
    row = new ArrayList<>();

    row.add(
      "Total # of Rides Ridden in " + targetYear + ": ");
    row.add(Integer.toString(ridesTotal));
    reportInfo.add(row);

    System.out.println(reportInfo);
    // add the row to reportInfo
    return reportInfo;
  }

  public ArrayList<String> findMax(ArrayList<String> target)
  {
    String element;
    int maxRides = 0;
    String maxRideName = "";
    int numRides = 0;
    ArrayList<String> summary = new ArrayList<>();
    while (!target.isEmpty())
    {
      element = target.get(0);
      numRides = 0;
      while (target.contains(element))
      {
        target.remove(element);
        numRides++;
      }
      if (numRides == maxRides)
      {
        maxRideName = maxRideName + " & " + element;
      }
      else if (numRides > maxRides)
      {
        maxRides = numRides;
        maxRideName = element;
      }
    }
    if (maxRides == 0)
    {
      maxRideName = "None";
    }
    summary.add(maxRideName);
    summary.add(Integer.toString(maxRides));
    return summary;
  }

  public ArrayList<ArrayList<String>> maintenanceReport(
    ArrayList<ArrayList<String>> data,
    String targetYear)
  {
    int ridesTotal = 0;
    int maxMonth = 12;
    ArrayList<String> row;
    ArrayList<ArrayList<String>> reportInfo = new ArrayList<>();

    // current date
    Format f = new SimpleDateFormat("MM-dd-yyyy");
    String curDate = f.format(new Date());
    String[] arrDate = curDate.split("-");
    // if the target year is current year, stop at current month
    if (targetYear.equals(arrDate[2]))
    {
      maxMonth = Integer.parseInt(arrDate[0]);
    }
    //go thru each month
    for (int m = 1; m <= maxMonth; m++)
    {
      int monthTotal = 0;
      String month1 = Integer.toString(m);
      String month2;
      if (m < 10)
      {
        month2 = "0" + month1;
      }
      else
      {
        month2 = month1;
      }
      for (int r = 0; r < data.size(); r++)
      {
        String cDate = data.get(r).get(2);
        cDate = parseDate(cDate);
        String cYear = parseYearStr(cDate);
        if (cYear.equals(targetYear))
        {
          String cMonth = parseMonthStr(cDate);
          if (cMonth.equals(month1)
            || cMonth.equals(month2))
          {
            monthTotal++;
          }
        }
      }
      ridesTotal = ridesTotal + monthTotal;
      // add equivalent month name and total to the row
      row = new ArrayList<>();
      row.add(convertMonth(month1));
      row.add(Integer.toString(monthTotal));
      reportInfo.add(row);
    }
    // add average per month to the list
    row = new ArrayList<>();
    row.add("Average # of Rides Needing Maintenance per Month: ");
    double average = (double) ridesTotal / maxMonth;
    average = average * 100;
    average = Math.round(average);
    average = average / 100;
    row.add(Double.toString(average));
    reportInfo.add(row);
    // add total customers to the list
    row = new ArrayList<>();
    row.add("Total # of Rides Needing Maintenance in " + targetYear + ": ");
    row.add(Integer.toString(ridesTotal));
    reportInfo.add(row);

    System.out.println(reportInfo);
    // add the row to reportInfo
    return reportInfo;
  }

  public ArrayList<ArrayList<String>> customerReport(
    ArrayList<ArrayList<String>> data,
    String targetYear)
  {
    int customerTotal = 0;
    int maxMonth = 12;
    ArrayList<String> row;
    ArrayList<ArrayList<String>> reportInfo = new ArrayList<>();
    // current date
    Format f = new SimpleDateFormat("MM-dd-yyyy");
    String curDate = f.format(new Date());
    String[] arrDate = curDate.split("-");
    // if the target year is current year, stop at current month
    if (targetYear.equals(arrDate[2]))
    {
      maxMonth = Integer.parseInt(arrDate[0]);
    }
    //go thru each month
    for (int m = 1; m <= maxMonth; m++)
    {
      int monthTotal = 0;
      String month1 = Integer.toString(m);
      String month2;
      if (m < 10)
      {
        month2 = "0" + month1;
      }
      else
      {
        month2 = month1;
      }
      for (int r = 0; r < data.size(); r++)
      {
        String cDate = data.get(r).get(1);
        cDate = parseDate(cDate);
        String cYear = parseYearStr(cDate);
        if (cYear.equals(targetYear))
        {
          String cMonth = parseMonthStr(cDate);
          if (cMonth.equals(month1)
            || cMonth.equals(month2))
          {
            monthTotal++;
          }
        }
      }
      customerTotal = customerTotal + monthTotal;
      // add equivalent month name and total to the row
      row = new ArrayList<>();
      row.add(convertMonth(month1));
      row.add(Integer.toString(monthTotal));
      reportInfo.add(row);
    }
    // add average per month to the list
    row = new ArrayList<>();
    row.add("Average # of Customers per Month: ");
    double average = (double) customerTotal / maxMonth;
    average = average * 100;
    average = Math.round(average);
    average = average / 100;
    row.add(Double.toString(average));
    reportInfo.add(row);
    // add total customers to the list
    row = new ArrayList<>();
    row.add("Total # of Customers in " + targetYear + ": ");
    row.add(Integer.toString(customerTotal));
    reportInfo.add(row);

    System.out.println(reportInfo);
    // add the row to reportInfo
    return reportInfo;
  }

  public String convertMonth(String digitMonth)
  {
    if (digitMonth.equals("1")
      || digitMonth.equals("01"))
    {
      return "January";
    }
    else if (digitMonth.equals("2")
      || digitMonth.equals("02"))
    {
      return "February";
    }
    else if (digitMonth.equals("3")
      || digitMonth.equals("03"))
    {
      return "March";
    }
    else if (digitMonth.equals("4")
      || digitMonth.equals("04"))
    {
      return "April";
    }
    else if (digitMonth.equals("5")
      || digitMonth.equals("05"))
    {
      return "May";
    }
    else if (digitMonth.equals("6")
      || digitMonth.equals("06"))
    {
      return "June";
    }
    else if (digitMonth.equals("7")
      || digitMonth.equals("07"))
    {
      return "July";
    }
    else if (digitMonth.equals("8")
      || digitMonth.equals("08"))
    {
      return "August";
    }
    else if (digitMonth.equals("9")
      || digitMonth.equals("09"))
    {
      return "September";
    }
    else if (digitMonth.equals("10"))
    {
      return "October";
    }
    else if (digitMonth.equals("11"))
    {
      return "November";
    }
    else if (digitMonth.equals("12"))
    {
      return "December";
    }
    else
    {
      return "";
    }
  }

  public String parseYearStr(String targetDate)
  {
    String strYear = "";
    int yearIndex;
    if (targetDate.equals(""))
    {
      return "";
    }
    else
    {
      // ck if there is - or / to separate
      int index = 0;
      while (index < targetDate.length()
        && (targetDate.charAt(index) != '-'
        && targetDate.charAt(index) != '/'))
      {
        index++;
      }
      if (index == targetDate.length())
      {
        return "";
      }
      //split the date
      String splitStr = Character.toString(
        targetDate.charAt(index));
      String[] dateArray = targetDate.split(splitStr);
      // find the index of year in dateArray
      if (dateArray.length == 3)
      {
        yearIndex = 2;
      }
      else if (dateArray.length == 2)
      {
        yearIndex = 1;
      }
      else // corrupted date
      {
        return "";
      }
      // check if year is four digits
      if (dateArray[yearIndex].length() != 4)
      {
        return "";
      }
      else
      {
        // check all four chars are digits
        for (int i = 0; i < dateArray[yearIndex].length(); i++)
        {
          if (!Character.isDigit(
            dateArray[yearIndex].charAt(i)))
          {
            return "";
          }
        }
        return dateArray[yearIndex];
      }
    }
  }

  public String parseMonthStr(String targetDate)
  {
    int intMonth = 0;
    String strMonth = "";

    if (Character.isDigit(targetDate.charAt(0)))
    {
      strMonth = strMonth + targetDate.charAt(0);
    }
    else
    {
      return "";
    }
    if (targetDate.charAt(1) != '-'
      && targetDate.charAt(1) != '/')
    {
      if (Character.isDigit(targetDate.charAt(1)))
      {
        if (targetDate.charAt(2) != '-'
          && targetDate.charAt(2) != '/')
        {
          return "";
        }
        else
        {
          strMonth = strMonth + targetDate.charAt(1);
        }
      }
      else
      {
        return "";
      }
    }
    if (!strMonth.equals(""))
    {
      intMonth = Integer.parseInt(strMonth);
      if (intMonth > 12 || intMonth < 1)
      {
        return "";
      }
      else
      {
        return strMonth;
      }
    }
    else
    {
      return "";
    }
  }

  public ArrayList<String> genReport()
  {
    ArrayList<String> myReport = new ArrayList<>();

    String dbName = "Theme_Park";
    JavaDatabase objDb = new JavaDatabase(dbName);

    int customerCount = objDb.getCustomerCount();
    ArrayList<String> ticketDates = objDb.getTicketDates();
    double avgPerMonth = averagePerMonth(ticketDates);
    int rideCount = objDb.getRideCount();
    int brokenRides = objDb.getBrokenRideCount();
    double averageBroken = (double) brokenRides / rideCount;
    averageBroken = averageBroken * 100;
    averageBroken = Math.round(averageBroken);
    averageBroken = averageBroken / 100;
    avgPerMonth = avgPerMonth * 100;
    avgPerMonth = Math.round(avgPerMonth);
    avgPerMonth = avgPerMonth / 100;

    myReport.add(Integer.toString(customerCount));
    myReport.add(Double.toString(avgPerMonth));
    myReport.add(Integer.toString(rideCount));
    myReport.add(Double.toString(averageBroken));

    return myReport;
  }

  public double averagePerMonth(ArrayList<String> dates)
  {
    String tDate;
    int tMonth;
    int tYear;
    int currentYr;
    int numYear = 1;
    int numMonth = 0;
    int totalCustomers = 0;
    double average;
    int[] customerCount = new int[12];
    for (int i = 0; i < customerCount.length; i++)
    {
      customerCount[i] = 0;
    }
    currentYr = parseYear(dates.get(0));
    for (int r = 0; r < dates.size(); r++)
    {
      tDate = dates.get(r);
      tYear = parseYear(tDate);

      if (tYear > currentYr)
      {
        currentYr = tYear;
        numYear++;
        for (int i = 0; i < customerCount.length; i++)
        {
          if (customerCount[i] != 0)
          {
            numMonth++;
            totalCustomers = totalCustomers + customerCount[i];
          }
        }
        for (int i = 0; i < customerCount.length; i++)
        {
          customerCount[i] = 0;
        }
      }
      tMonth = parseMonth(tDate);
      if (tMonth != 0)
      {
        customerCount[(tMonth - 1)]++;
      }
    }

    for (int i = 0; i < customerCount.length; i++)
    {
      if (customerCount[i] != 0)
      {
        numMonth++;
        totalCustomers = totalCustomers + customerCount[i];
      }
    }
    average = (double) totalCustomers / numMonth;
    return average;
  }

  public String parseDate(String targetDate)
  {
    String finalDate = "";
    if (targetDate.equals(""))
    {
      return targetDate;
    }
    else
    {
      int index = 0;
      while (index < targetDate.length()
        && (targetDate.charAt(index) != '-'
        && targetDate.charAt(index) != '/'))
      {
        index++;
      }
      if (index == targetDate.length())
      {
        return targetDate;
      }
      String splitStr = Character.toString(
        targetDate.charAt(index));
      String[] dateArray = targetDate.split(splitStr);
      if (dateArray.length != 3)
      {
        return targetDate;
      }
      else
      {
        if (dateArray[0].length() == 0
          || dateArray[1].length() == 0
          || dateArray[2].length() == 0)
        {
          return targetDate;
        }
      }
      if (index == 4)
      {
        if (Integer.parseInt(dateArray[1]) > 12
          && Integer.parseInt(dateArray[1]) < 32)
        {
          String temp = dateArray[0];
          dateArray[0] = dateArray[2];
          dateArray[2] = temp;
        }
        else
        {
          String temp = dateArray[0];
          dateArray[0] = dateArray[1];
          dateArray[1] = dateArray[2];
          dateArray[2] = temp;
        }
      }
      // year at the middle
      else if (dateArray[1].length() == 4)
      {
        if (Integer.parseInt(dateArray[0]) > 12
          && Integer.parseInt(dateArray[0]) < 32)
        {
          String temp = dateArray[0];
          dateArray[0] = dateArray[2];
          dateArray[2] = dateArray[1];
          dateArray[1] = temp;
        }
        else
        {
          String temp = dateArray[1];
          dateArray[1] = dateArray[2];
          dateArray[2] = temp;
        }
      }
      // year at the end  
      else
      {
        if (Integer.parseInt(dateArray[0]) > 12
          && Integer.parseInt(dateArray[0]) < 32)
        {
          String temp = dateArray[0];
          dateArray[0] = dateArray[1];
          dateArray[1] = temp;
        }
      }
      finalDate = dateArray[0] + "-" + dateArray[1]
        + "-" + dateArray[2];
      return finalDate;
    }
  }

  public int parseYear(String targetDate)
  {
    int intYear = 0;
    String strYear = "";
    int index = 0;
    while (index < targetDate.length()
      && targetDate.charAt(index) != '-'
      && targetDate.charAt(index) != '/')
    {
      index++;
    }
    index++;
    while (index < targetDate.length()
      && targetDate.charAt(index) != '-'
      && targetDate.charAt(index) != '/')
    {
      index++;
    }
    index++;
    while (index < targetDate.length())
    {
      strYear = strYear + targetDate.charAt(index);
      index++;
    }
    if (!strYear.equals("") && strYear.length() == 4)
    {
      return intYear = Integer.parseInt(strYear);
    }
    else
    {
      return 0;
    }
  }

  public int parseMonth(String targetDate)
  {
    int intMonth = 0;
    String strMonth = "";
    if (Character.isDigit(targetDate.charAt(0)))
    {
      strMonth = strMonth + targetDate.charAt(0);
    }
    else
    {
      return 0;
    }
    if (targetDate.charAt(1) != '-'
      && targetDate.charAt(1) != '/')
    {
      if (Character.isDigit(targetDate.charAt(1)))
      {
        strMonth = strMonth + targetDate.charAt(1);
      }
      else
      {
        return 0;
      }
    }
    if (!strMonth.equals(""))
    {
      intMonth = Integer.parseInt(strMonth);
      if (intMonth > 12 || intMonth < 1)
      {
        return 0;
      }
      else
      {
        return intMonth;
      }
    }
    else
    {
      return 0;
    }
  }
}
