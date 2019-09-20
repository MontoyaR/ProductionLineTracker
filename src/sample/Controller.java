package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Controller {

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
}
