package sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The starting point of the program.
 *
 * @author Ricardo Montoya
 */
public class Main extends Application {

  /**
   * The starting point of a JavaFX program.
   *
   * @param primaryStage the first thing a user sees.
   * @throws Exception errors found within code.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load(getClass().getResource("ProductionLineTracker.fxml"));
    primaryStage.setTitle("Production Line Tracker");
    primaryStage.setScene(new Scene(root, 1000, 600));
    primaryStage.show();
  }

  /**
   * Main start of the program.
   *
   * @param args —
   */
  public static void main(String[] args) {

    launch(args);
  }
}
