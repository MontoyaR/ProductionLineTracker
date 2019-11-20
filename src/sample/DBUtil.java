package sample;

import com.sun.rowset.CachedRowSetImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;

/**
 * Database used to initialize a connection the the H2 database.
 *
 * @author Ricardo Montoya
 */
public class DBUtil {

  //Database Credentials
  private static final String JDBC_DRIVER = "org.h2.Driver";
  private static final String DB_URL = "jdbc:h2:./res/HR";

  static final String USER = "";
  static String PASS = "";




  //Connection
  private static Connection conn = null;

  /**
   * Establish connection to database
   *
   * @throws ClassNotFoundException
   * @throws SQLException
   */
  public static void dbConnect() throws ClassNotFoundException, SQLException, IOException {
    //Setting H2 JDBC Driver
    try {
      Class.forName(JDBC_DRIVER);
    } catch (ClassNotFoundException e) {
      System.out.println("Where is your Oracle JDBC Driver?");
      e.printStackTrace();
      throw e;
    }

    Properties prop = new Properties();
    prop.load(new FileInputStream("res/properties"));
    PASS = prop.getProperty("password");

    System.out.println("\nOracle Driver Registered!\n");

    //Establish the H2 Connection using Connection String
    try {
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (SQLException e) {
      System.out.println("Connection Failed! Check output console" + e);
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Disconnect from the database
   *
   * @throws SQLException
   */
  public static void dbDisconnect() throws SQLException {
    try {
      if (conn != null && !conn.isClosed() ){
        conn.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Database Execute Query Operation
   *
   * @param queryStmt
   * @return
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  public static ResultSet dbExecuteQuery(String queryStmt)
      throws SQLException, ClassNotFoundException, IOException {
    //Declare statement, resultSet and CachedResultSet as null
    Statement stmt = null;
    ResultSet resultSet = null;
    CachedRowSetImpl crs = null;
    try {
      //Connect to DB (Establish Oracle Connection)
      dbConnect();
      System.out.println("Select statement: " + queryStmt + "\n");

      //Create statement
      stmt = conn.createStatement();

      //Execute select (query) operation
      resultSet = stmt.executeQuery(queryStmt);

      //CachedRowSet Implementation
      //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
      //We are using CachedRowSet
      crs = new CachedRowSetImpl();
      crs.populate(resultSet);
    } catch (SQLException | IOException e) {
      System.out.println("Problem occurred at executeQuery operation : " + e);
      throw e;
    } finally {
      if (resultSet != null) {
        //Close resultSet
        resultSet.close();
      }
      if (stmt != null) {
        //Close Statement
        stmt.close();
      }
      //Close connection
      dbDisconnect();
    }
    //Return CachedRowSet
    return crs;
  }

  /**
   * Database Execute Update (For Update/Insert/Delete) Operation
   * @param sqlStmt
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  public static void dbExecuteUpdate(String sqlStmt)
      throws SQLException, ClassNotFoundException, IOException {
    //Declare statement as null
    Statement stmt = null;
    try {
      //Connect to DB (Establish Oracle Connection)
      dbConnect();
      System.out.println("Select statement: " + sqlStmt + "\n");

      //Create Statement
      stmt = conn.createStatement();

      //Run executeUpdate operation with given sql statement
      stmt.executeUpdate(sqlStmt);
    } catch (SQLException | IOException e) {
      System.out.println("Problem occurred at executeUpdate operation : " + e);
      throw e;
    } finally {
      if (stmt != null) {
        //Close statement
        stmt.close();
      }
      //Close connection
      dbDisconnect();
    }
  }
}