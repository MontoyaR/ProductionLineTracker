package sample;


import java.util.ArrayList;
import java.util.Date;
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

    Product product1 = new Widget("iPod", "Apple", "AM");
    System.out.println(product1.toString());
    System.out.println("");

    Product product2 = new Widget("Zune", "Microsoft", "AM");
    System.out.println(product2.toString());
    System.out.println("");

    AudioPlayer newProduct = new AudioPlayer("DP-X1A", "Onkyo",
        "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    System.out.println(newProduct);
    newProduct.play();
    newProduct.stop();
    newProduct.next();
    newProduct.previous();
    System.out.println("");

    AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
        "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    Screen newScreen = new Screen("720x480", 40, 22);
    MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,
        MonitorType.LCD);
    ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();
    productList.add(newAudioProduct);
    productList.add(newMovieProduct);
    for (MultimediaControl p : productList) {
      System.out.println(p);
      p.play();
      p.stop();
      p.next();
      p.previous();
    }

    System.out.println();



    // test constructor used when creating production records from user interface
    Integer numProduced = 3;  // this will come from the combobox in the UI

    for (int productionRunProduct = 0; productionRunProduct < numProduced; productionRunProduct++) {
      ProductionRecord pr = new ProductionRecord(productionRunProduct);
      // using the iterator as the product id for testing
      System.out.println(pr.toString());
    }

    // test constructor used when creating production records from reading database
    ProductionRecord pr = new ProductionRecord(0, 3, "1", new Date());
    System.out.println(pr.toString());

    // testing accessors and mutators
    pr.setProductionNum(1);
    System.out.println(pr.getProductionNum());

    pr.setProductID(4);
    System.out.println(pr.getProductID());

    pr.setSerialNum("2");
    System.out.println(pr.getSerialNum());

    pr.setProdDate(new Date());
    System.out.println(pr.getProdDate());
  }
}
