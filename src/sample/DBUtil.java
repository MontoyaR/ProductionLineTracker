package sample;

import com.sun.rowset.CachedRowSetImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.sql.rowset.CachedRowSet;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

/**
 * Database used to initialize a connection the the H2 database.
 *
 * @author Ricardo Montoya
 */
public class DBUtil {

  //Database Credentials
  private final String JDBC_DRIVER = "org.h2.Driver";
  private final String DB_URL = "jdbc:h2:./res/HR";

  final String USER = "";
  final String PASS = "";

  //Connection
  private Connection conn = null;

  /**
   * Establish connection to database
   *
   * @throws ClassNotFoundException
   * @throws SQLException
   */
  public void dbConnect() throws ClassNotFoundException, SQLException {
    //Setting H2 JDBC Driver
    try {
      Class.forName(JDBC_DRIVER);
    } catch (ClassNotFoundException e) {
      System.out.println("Where is your Oracle JDBC Driver?");
      e.printStackTrace();
      throw e;
    }

    System.out.println("Oracle Driver Registered!");

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
  public void dbDisconnect() throws SQLException {
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
  public ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
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
   * Database Execute Update (For Update/Insert/Delete) Operation
   * @param sqlStmt
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  public void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
    //Declare statement as null
    Statement stmt = null;
    try {
      //Connect to DB (Establish Oracle Connection)
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














  /**
   * Method used to establish a connection to the database.
   *
   * @return
   */
  public static Connection initializeDB() throws IOException {

    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/HR";

    final String USER = "";
//    final String PASS = "PASS";

    Properties prop = new Properties();
    prop.load(new FileInputStream("res/properties"));
    final String PASS = prop.getProperty("password");

    try {
      Class.forName(JDBC_DRIVER);
      Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

      return conn;

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
}