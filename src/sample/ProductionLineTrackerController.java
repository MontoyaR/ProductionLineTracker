package sample;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.sql.Connection;
import sample.DatabaseHandler;

/**
 * Handles mouse and keyboard events.
 *
 * @author Ricardo Montoya
 */
public class ProductionLineTrackerController {

  //--
  Connection connection = null;
  PreparedStatement preparedStatement = null;
  ResultSet resultSet = null;

  @FXML
  private TextField txtProductName;

  @FXML
  private TextField txtManufacturer;

  @FXML
  public ChoiceBox<ItemType> chbxItemType;

  @FXML
  private TextArea ProductionLog;



  @FXML
  private TableColumn<Integer, Product> tabcolID;

  @FXML
  private TableColumn<String, Product> tabcolName;

  @FXML
  private TableColumn<String, Product> tabcolType;

  @FXML
  private TableColumn<String, Product> tabcolManufacturer;

  @FXML
  public ComboBox<String> cbxQuantity;
  ObservableList<String> list = FXCollections
      .observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

  @FXML
  void Println(MouseEvent event) {
    System.out.println("Printing to console.");
  }

  @FXML
  void printSelect(MouseEvent event){
    String type = chbxItemType.getValue().toString();
    System.out.println(type);
  }

  @FXML
  void handleAddProduct(MouseEvent event){
    String productName = txtProductName.getText();
    String type = chbxItemType.getValue().toString();
    String manufacturer = txtManufacturer.getText();
    String sqlStmt = "INSERT INTO PRODUCT(NAME, TYPE, MANUFACTURER) VALUES (?, ?, ?)";
    try {
      preparedStatement = connection.prepareStatement(sqlStmt);
      preparedStatement.setString(1,productName);
      preparedStatement.setString(2, type);
      preparedStatement.setString(3, manufacturer);
      preparedStatement.executeUpdate();
    } catch (Exception e){
      e.printStackTrace();
    }
  }

  @FXML
  void loadProducts(Product product){

  }


 @FXML
  public void initialize() {
    connection = DatabaseHandler.initializeDB();

    cbxQuantity.setItems(list);
    cbxQuantity.setEditable(true);
    cbxQuantity.getSelectionModel().selectFirst();

    chbxItemType.getItems().setAll(ItemType.values());

  }
}
