package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

/**
 * Handles mouse and keyboard events.
 * @author Ricardo Montoya
 */
public class Controller implements Initializable {

  @FXML
  private Button btnPrint;

  @FXML
  void Println(MouseEvent event) {
    System.out.println("Printing to console.");
  }

  @FXML
  void addProduct(MouseEvent event) {

    System.out.println("Printing to console.");
  }

  @FXML
  public ComboBox<String> combobox;
  ObservableList<String> list = FXCollections
      .observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    combobox.setItems(list);

  }
}
