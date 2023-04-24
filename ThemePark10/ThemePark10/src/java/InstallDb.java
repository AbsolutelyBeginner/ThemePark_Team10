// Ariya Ansari

public class InstallDb
{

    public static void main(String[] args)
    {
        String dbName = "Web1";
        JavaDatabase dbObj = new JavaDatabase();
        dbObj.createDb(dbName);
        // create table
        String newTable = "CREATE TABLE cars (name varchar(50),"
            + "price int, color varchar(50) )";
        dbObj.createTable(newTable, dbName);
    }
}
