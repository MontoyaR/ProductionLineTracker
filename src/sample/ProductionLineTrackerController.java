package sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * Controller used to handle the .
 *
 * @author Ricardo Montoya
 */
public class ProductionLineTrackerController {

  @FXML
  public ChoiceBox<ItemType> chbxItemType;

  @FXML
  private TextArea ProductionLog;

  @FXML
  public ComboBox<String> cbxQuantity;

  //TextField
  @FXML
  private TextField txtProductName;
  @FXML
  private TextField txtManufacturer;
  @FXML
  private TextField txtProductID;

  //TableView
  @FXML
  private TableView<Product> tableView;
  @FXML
  private TableColumn<Product, Integer> idCol;
  @FXML
  private TableColumn<Product, String> nameCol;
  @FXML
  private TableColumn<Product, String> typeCol;
  @FXML
  private TableColumn<Product, String> manufacturerCol;

  @FXML
  void Println(MouseEvent event) {
    System.out.println("Printing to console.");
  }

  /**
   * Method used to initialize connection, attributes, and methods.
   */
  @FXML
  public void initialize() {

    initCombobox();
    initCol();

    ProductionRecord pr = new ProductionRecord(0, 3, "1", new Date());
    ProductionLog.setText(pr.toString());
  }

  /**
   * @param event
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  @FXML
  private void setupProductLineTable(ActionEvent event)
      throws SQLException, ClassNotFoundException, IOException {
    try {
      //Get all Product Information
      ObservableList<Product> productLine = listProducts();

      //Populate Products on TableView
      tableView.setItems(productLine);
    } catch (SQLException | IOException e) {
      System.out
          .println("Error occurred while getting product information from the database.\n" + e);
      throw e;
    }
  }

  @FXML
  private void searchProduct(ActionEvent actionEvent)
      throws SQLException, ClassNotFoundException, IOException {
    try {
      //Get Product Information
      Product prod = searchProd(txtProductID.getText());

      //Populate Product on TableView
      populateProduct(prod);
    } catch (SQLException | IOException e) {
      System.out
          .println("Error occurred while getting employee information from the database.\n" + e);
      throw e;
    }
  }

  /**
   *
   * @param prod
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  @FXML
  private void populateProduct(Product prod) throws SQLException, ClassNotFoundException {
    //Declare an ObservableList for the TableView
    ObservableList<Product> prodData = FXCollections.observableArrayList();

    //Add Product to the ObservableList
    prodData.add(prod);

    //Set items to the TableView
    tableView.setItems(prodData);
  }

  /**
   * @param actionEvent
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  @FXML
  private void insertProduct(ActionEvent actionEvent)
      throws SQLException, ClassNotFoundException, IOException {
    try {
      insertProd(txtProductName.getText(), chbxItemType.getValue().toString(),
          txtManufacturer.getText());
    } catch (SQLException | IOException e) {
      System.out.println("Problem occurred while inserting product: " + e);
      throw e;
    }
  }

  /**
   * @param actionEvent
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  @FXML
  private void deleteProduct(ActionEvent actionEvent)
      throws SQLException, ClassNotFoundException, IOException {
    try {
      deleteProdWithID(txtProductID.getText());
    } catch (SQLException | IOException e) {
      System.out.println("Problem occurred while deleting product: " + e);
      throw e;
    }
  }

  /**
   * initComboBox method is used to initialize the values in the ComboBox
   */
  public void initCombobox() {
    ObservableList<String> lists = FXCollections
        .observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    cbxQuantity.setItems(lists);
    cbxQuantity.setEditable(true);
    cbxQuantity.getSelectionModel().selectFirst();
    chbxItemType.getItems().setAll(ItemType.values());
  }

  /**
   * initCol method used to initialize the columns for the TableView.
   */
  public void initCol() {
    //Note: The first word must match the id from fxml and the last word must match the field name
    idCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
    nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
    manufacturerCol.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
    typeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
  }


  /**
   * This method holds an ObservableList which comprises of Product Object. This allows the transfer
   * of the ObservableList.
   *
   * @param rs
   * @return
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  private ObservableList<Product> getProductList(ResultSet rs)
      throws SQLException, ClassNotFoundException {
    //Declare an ObservableList which comprises of Product Objects
    ObservableList<Product> prodList = FXCollections.observableArrayList();

    while (rs.next()) {
      Product prod = new Widget();
      prod.setId(rs.getInt("ID"));
      prod.setName(rs.getString("NAME"));
      prod.setType(rs.getString("TYPE"));
      prod.setManufacturer(rs.getString("MANUFACTURER"));

      //Add Product to the ObservableList
      prodList.add(prod);
    }
    //Return prodList (ObservableList of Products)
    return prodList;
  }

  /**
   * @return
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  private ObservableList<Product> listProducts()
      throws SQLException, ClassNotFoundException, IOException {
    //Declare a SELECT statement
    String selectStmt = "SELECT * FROM PRODUCT";

    //Execute SELECT statement
    try {
      //Get ResultSet from dbExecuteQuery method
      ResultSet rsProd = DBUtil.dbExecuteQuery(selectStmt);

      //Send ResultSet to the getProductList method and get Product Object
      ObservableList<Product> prodList = getProductList(rsProd);

      //Return Product Object
      return prodList;
    } catch (SQLException | IOException e) {
      System.out.println("SQL SELECT Operation has has failed: " + e);
      throw e;
    }
  }

  /**
   * Use ResultSet from Database as parameter and set Product's Object attributes and return Product
   * Object.
   *
   * @param rs
   * @return
   * @throws SQLException
   */
  private Product getProductFromResultSet(ResultSet rs) throws SQLException {
    Product prod = null;
    if (rs.next()) {
      prod = new Widget();
      prod.setId(rs.getInt("ID"));
      prod.setName(rs.getString("NAME"));
      prod.setType(rs.getString("TYPE"));
      prod.setManufacturer(rs.getString("MANUFACTURER"));
    }
    return prod;
  }

  private Product searchProd(String prodID) throws SQLException, ClassNotFoundException, IOException {
    //Declare SELECT statement
    String selectStmt = "SELECT * FROM PRODUCT WHERE ID=" + prodID + ";";

    //Execute SELECT statement
    try {
      //Get ResultSet from dbExecuteQuery method
      ResultSet rsProd = DBUtil.dbExecuteQuery(selectStmt);

      //Send ResultSet to the getProductFromResultSet method and get Product Object
      Product product = getProductFromResultSet(rsProd);

      //Return Product Object
      return product;
    } catch (SQLException | IOException e) {
      System.out
          .println("While searching a product with " + prodID + " id, an error occurred : + e");
      throw e;
    }
  }

  /**
   * @param name
   * @param type
   * @param manufacturer
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  private void insertProd(String name, String type, String manufacturer)
      throws SQLException, ClassNotFoundException, IOException {
    //Declare INSERT statement
    String updateStmt = "INSERT INTO PRODUCT(NAME, TYPE, MANUFACTURER) VALUES('" + name + "', '" +
        type + "', '" + manufacturer + "');";

    //Execute INSERT statement
    try {
      DBUtil.dbExecuteUpdate(updateStmt);
      System.out.println("Inserting Product:" + "\nProduct: " + name + "\nType: " + type + "\nManufacturer: " + manufacturer);
    } catch (SQLException | IOException e) {
      System.out.println("Error occurred while INSERT operation: " + e);
      throw e;
    }
  }

  /**
   * @param prodID
   * @throws SQLException
   * @throws ClassNotFoundException
   */
  private void deleteProdWithID(String prodID)
      throws SQLException, ClassNotFoundException, IOException {
    //Declare DELETE statement
    String updateStmt = "DELETE FROM PRODUCT WHERE ID=" + prodID + ";";

    //Execute DELETE statement
    try {
      DBUtil.dbExecuteUpdate(updateStmt);
    } catch (SQLException | IOException e) {
      System.out.println("Error occurred while DELETE operation: " + e);
      throw e;
    }
  }
}