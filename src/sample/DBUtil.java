package sample;

import com.sun.rowset.CachedRowSetImpl;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * Database used to initialize a connection the the H2 database.
 *
 * @author Ricardo Montoya
 */
public class DBUtil {

  //Database Credentials
  private static final String JDBC_DRIVER = "org.h2.Driver";
  private static final String DB_URL = "jdbc:h2:./res/HR";

  private static final String USER = "";
  private static String PASS = "";

  //Connection
  private static Connection conn = null;

  /**
   * Establish connection to database.
   *
   * @throws ClassNotFoundException — Thrown when an application tries to load in a class through
   *                                its string name using: The forName method in class Class. The
   *                                findSystemClass method in class ClassLoader . The loadClass
   *                                method in class ClassLoader.
   * @throws SQLException           — An exception that provides information on a database access
   *                                error or other errors.
   * @throws IOException            — Signals that an I/O exception of some sort has occurred. This
   *                                class is the general class of exceptions produced by failed or
   *                                interrupted I/O operations.
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

    System.out.println("\nOracle Driver Registered!\n");

    //Establish the H2 Connection using Connection String
    try {
      //Get password Properties file
      Properties prop = new Properties();
      prop.load(new FileInputStream("res/properties"));
      PASS = prop.getProperty("password");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (SQLException e) {
      System.out.println("Connection Failed! Check output console" + e);
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Disconnect from the database.
   *
   * @throws SQLException           — An exception that provides information on a database access
   *                                error or other errors.
   */
  public static void dbDisconnect() throws SQLException {
    try {
      if (conn != null && !conn.isClosed()) {
        conn.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    }
  }

  /**
   * Database Execute Query Operation.
   *
   * @param queryStmt — String variable used to execute query SQL operations.
   * @throws ClassNotFoundException — Thrown when an application tries to load in a class through
   *                                its string name using: The forName method in class Class. The
   *                                findSystemClass method in class ClassLoader . The loadClass
   *                                method in class ClassLoader.
   * @throws SQLException           — An exception that provides information on a database access
   *                                error or other errors.
   * @throws IOException            — Signals that an I/O exception of some sort has occurred. This
   *                                class is the general class of exceptions produced by failed or
   *                                interrupted I/O operations.
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
   * Database Execute Update (For Update/Insert/Delete) Operation.
   *
   * @param sqlStmt — String variable used to execute update SQL operations.
   * @throws ClassNotFoundException — Thrown when an application tries to load in a class through
   *                                its string name using: The forName method in class Class. The
   *                                findSystemClass method in class ClassLoader . The loadClass
   *                                method in class ClassLoader.
   * @throws SQLException           — An exception that provides information on a database access
   *                                error or other errors.
   * @throws IOException            — Signals that an I/O exception of some sort has occurred. This
   *                                class is the general class of exceptions produced by failed or
   *                                interrupted I/O operations.
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