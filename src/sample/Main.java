package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * The starting point of the program.
 *
 * @author ramontoya7474
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
    primaryStage.setScene(new Scene(root, 800, 550));
    primaryStage.show();
  }

  public static void main(String[] args) {

    launch(args);

//    Product product1 = new Widget("iPod", "Apple", "AM");
//    System.out.println(product1.toString());
//
//    Product product2 = new Widget("Zune", "Microsoft", "AM");
//    System.out.println(product2.toString());

    AudioPlayer newProduct = new AudioPlayer("DP-X1A", "Onkyo", "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    System.out.println(newProduct);
    newProduct.play();
    newProduct.stop();
    newProduct.next();
    newProduct.previous();



  }
}
