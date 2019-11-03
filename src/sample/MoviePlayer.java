package sample;

/**
 * Represents a MoviePlayer that is a subclass of the Product Class and implements the
 * MultimediaControl Interface.
 *
 * @author Ricardo Montoya
 */
public class MoviePlayer extends Product implements MultimediaControl {

  /**
   * MoviePlayer constructor sets the screen and monitorType and calls the super class, Product, to
   * receive the name and manufacturer. MoviePlayer also called the Interface, MultimediaControl, to
   * set the Type.
   *
   * @param name         — name of the Product
   * @param manufacturer — manufacturer for the Product
   * @param screen       — screen
   * @param monitorType  — monitorType
   */
  MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer);
    super.setType("VISUAL");
    setScreen(screen);
    setMonitorType(monitorType);
  }

  /**
   * Variables of specific object types; Screen, MonitorType.
   */
  Screen screen;
  MonitorType monitorType;

  /**
   * getScreen method used to get screen of Object Screen.
   *
   * @return
   */
  public Screen getScreen() {
    return screen;
  }

  /**
   * setScreen method used to set the screen of Object Screen.
   *
   * @param screen — screen
   */
  public void setScreen(Screen screen) {
    this.screen = screen;
  }

  /**
   * getMonitorType method used to get monitorType of Object MonitorType.
   *
   * @return
   */
  public MonitorType getMonitorType() {
    return monitorType;
  }

  /**
   * setMonitorType method used to set the monitorType of Object MonitorType.
   *
   * @param monitorType — monitorType
   */
  public void setMonitorType(MonitorType monitorType) {
    this.monitorType = monitorType;
  }

  /**
   * This method uses the Override function to change the toString method from the super class,
   * Product.
   *
   * @return
   */
  @Override
  public String toString() {
    return super.toString() + "\nScreen:" + screen + "\nMonitor Type: " + monitorType;
  }

  /**
   * This method uses the Override function to change the play method from the super class,
   * Product.
   */
  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  /**
   * This method uses the Override function to change the stop method from the super class,
   * Product.
   */
  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  /**
   * This method uses the Override function to change the previous method from the super class,
   * Product.
   */
  @Override
  public void previous() {
    System.out.println("Previous movie");

  }

  /**
   * This method uses the Override function to change the next method from the super class,
   * Product.
   */
  @Override
  public void next() {
    System.out.println("Next movie");

  }
}
