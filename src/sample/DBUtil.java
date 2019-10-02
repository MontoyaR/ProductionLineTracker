package sample;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DBUtil class is responsible for Database connection, Database disconnection, database query and
 * update operations. It also throws helpful information on the exception.
 *
 * @author Ricardo Montoya
 */
public class DBUtil {

  //Declare JDBC Driver
  private static final String JDBC_DRIVER = "org.h2.Driver";

  //Connection
  private static Connection conn = null;

  //Database credentials
  private static final String DB_URL = "jdbc:h2:./res/HR";
  private static final String USER = "";
  private static final String PASS = "";

  /**
   * dbConnect() method is responsible for establishing a connection to the database.
   *
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  public static void dbConnect() throws SQLException, ClassNotFoundException {
    //Setting H2 JDBC Driver
    try {
      Class.forName(JDBC_DRIVER);
    } catch (ClassNotFoundException e) {
      System.out.println("Where is your Oracle JDBC Driver?");
      e.printStackTrace();
      throw e;
    }

    System.out.println("Oracle JDBC Driver Registered!");

    //Establish the H2 Connection using Connection String
    try {
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (SQLException e) {
      System.out.println("Connection Failed! Check output console" + e);
      e.printStackTrace();
      throw e;
    }
  }

  //Close Connection
  public static void dbDisconnect() throws SQLException {
    try {
      if (conn != null && !conn.isClosed()) {
        conn.close();
      }
    } catch (Exception e) {
      throw e;
    }
  }

  /**
   * dbExecuteQuery(...) method executes the query statement. It uses dbConnect() method to establish a connection
   * and once the query statement has been implemented it uses dbDisconnect() method to close the
   * connection.
   *
   * @param queryStmt
   * @return
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  public static ResultSet dbExecuteQuery(String queryStmt)
      throws SQLException, ClassNotFoundException {
    //Declare statement, resultSet and CachedResultSet as null
    Statement stmt = null;
    ResultSet resultSet = null;
    CachedRowSetImpl crs = null;
    try {
      //Connect to DB (Establish H2 Connection)
      dbConnect();
      System.out.println("Select statement: " + queryStmt + "\n");

      //Create statement
      stmt = conn.createStatement();

      //Execute select (query) operation
      resultSet = stmt.executeQuery(queryStmt);

      //CachedRowSet Implementation
      //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
      //use CachedRowSet
      crs = new CachedRowSetImpl();
      crs.populate(resultSet);
    } catch (SQLException e) {
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
   * dbExecuteUpdate(...) method executes given Update, Insert, Delete SQL operations.
   *
   * @param sqlStmt
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
    //Declare statement as null
    Statement stmt = null;
    try {
      //Connect to DB (Establish H2 Connection)
      dbConnect();
      //Create Statement
      stmt = conn.createStatement();
      //Run executeUpdate operation with given sql statement
      stmt.executeUpdate(sqlStmt);
    } catch (SQLException e) {
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
