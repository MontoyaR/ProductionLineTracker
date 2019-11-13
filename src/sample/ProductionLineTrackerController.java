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

  /**
   * Database.
   */
  Connection connection = null;
  PreparedStatement preparedStatement = null;
  ResultSet resultSet = null;

  ArrayList<Product> productLine = new ArrayList<>();
  ObservableList<Product> list = FXCollections.observableArrayList(productLine);

  ObservableList<String> lists = FXCollections
      .observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");


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

  /**
   *
   * @param event
   */
  @FXML
  private void handleRefresh(ActionEvent event) {
    setupProductLineTable();
  }

  /**
   * Method used to display "Printing to console" on mouse click.
   *
   * @param event — event
   */
  @FXML
  void Println(MouseEvent event) {
    System.out.println("Printing to console.");
  }

  /**
   * Method used to display the item type to the console.
   *
   * @param event — event
   */
  @FXML
  void printSelect(MouseEvent event) {
    String type = chbxItemType.getValue().toString();
    System.out.println(type);
  }

  /**
   * handleAddProduct method is used to send the String data typed into the textfield to the
   * database. The data is sent when the button is clicked.
   *
   * @param event — event
   */
  @FXML
  void handleAddProduct(MouseEvent event) {
    String productName = txtProductName.getText();
    String type = chbxItemType.getValue().toString();
    String manufacturer = txtManufacturer.getText();
    String sqlStmt = "INSERT INTO PRODUCT(NAME, TYPE, MANUFACTURER) VALUES (?, ?, ?)";
    try {
      preparedStatement = connection.prepareStatement(sqlStmt);
      preparedStatement.setString(1, productName);
      preparedStatement.setString(2, type);
      preparedStatement.setString(3, manufacturer);
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Method used to initialize connection, attributes, and methods.
   */
  @FXML
  public void initialize() throws IOException {
    connection = DBUtil.initializeDB();

    initCombobox();
    initCol();
    setupProductLineTable();

    ProductionRecord pr = new ProductionRecord(0, 3, "1", new Date());
    ProductionLog.setText(pr.toString());
  }

  /**
   *
   */
  public void initCombobox() {
    cbxQuantity.setItems(lists);
    cbxQuantity.setEditable(true);
    cbxQuantity.getSelectionModel().selectFirst();

    chbxItemType.getItems().setAll(ItemType.values());
  }

  /**
   * initCol method used to initialize the columns for the TableView.
   */
  public void initCol() {
    idCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
    nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
    manufacturerCol.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
    typeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
  }

  /**
   * setupProductLineTable method used to display the database table, PRODUCT, into the table view.
   */
  public void setupProductLineTable() {
    list.clear();

    String sql = "SELECT * FROM PRODUCT";

    try {
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        int ID = rs.getInt("Id");
        String NAME = rs.getString("Name");
        String MANUFACTURER = rs.getString("Manufacturer");
        String TYPE = rs.getString("Type");
        list.add(new Widget(ID, NAME, MANUFACTURER, TYPE));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    tableView.setItems(list);
  }
}