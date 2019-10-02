package sample;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

/**
 * Handles mouse and keyboard events.
 *
 * @author Ricardo Montoya
 */
public class Controller implements Initializable {

  @FXML
  void Println(MouseEvent event) {
    System.out.println("Printing to console.");
  }

  @FXML
  void addProduct(MouseEvent event) {
    String sqlAddProduct = "INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', 'Apple', 'iPod' )";
  }

  @FXML
  public ComboBox<String> cbxQuantity;
  ObservableList<String> list = FXCollections
      .observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

  @FXML
  public ChoiceBox<ItemType> chbxItemType;

  /**
   * Called to initialize a controller after its root element has been
   * completely processed.
   *
   * @param location
   * @param resources
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {

    cbxQuantity.setItems(list);
    cbxQuantity.setEditable(true);
    cbxQuantity.getSelectionModel().selectFirst();

    chbxItemType.getItems().setAll(ItemType.values());

  }
}
