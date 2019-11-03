package sample;

/**
 * Represents a Screen that implements ScreenSpec Interface.
 *
 * @author Ricardo Montoya
 */
public class Screen implements ScreenSpec {

  /**
   * Private variables used to represent Screen.
   */
  private String resolution;
  private int refreshrate;
  private int responsetime;

  /**
   * Screen constructor used to set the resolution, refreshrate, and responsetime.
   *
   * @param resolution — resolution of the Screen
   * @param refreshrate — refreshrate of the Screen
   * @param responsetime — reponsetime of the Screen
   */
  Screen(String resolution, int refreshrate, int responsetime) {
    setResolution(resolution);
    setRefreshrate(refreshrate);
    setResponsetime(responsetime);
  }

  /**
   * toString super method used to display the resolution, refreshrate, and response time to the
   * console.
   *
   * @return
   */
  @Override
  public String toString() {
    return "\nResolution: " + resolution
        + "\nRefresh rate: " + refreshrate + "\nResponse time: " + responsetime;
  }

  /**
   * getResolution method used to receive the resolution.
   *
   * @return
   */
  public String getResolution() {
    return resolution;
  }

  /**
   * getRefreshRate method used to receive the refreshrate.
   *
   * @return
   */
  public int getRefreshRate() {
    return refreshrate;
  }

  /**
   * getResponseTime method used to receive the responsetime.
   *
   * @return
   */
  public int getResponseTime() {
    return responsetime;
  }

  /**
   * setResolution method used to set the resolution.
   *
   * @param resolution — resolution of the Screen
   */
  public void setResolution(String resolution) {
    this.resolution = resolution;
  }

  /**
   * getRefreshrate method used to receive refreshrate.
   *
   * @return
   */
  public int getRefreshrate() {
    return refreshrate;
  }

  /**
   * setRefreshrate method used to set the refreshrate.
   *
   * @param refreshrate — refreshrate of the Screen
   */
  public void setRefreshrate(int refreshrate) {
    this.refreshrate = refreshrate;
  }

  /**
   * getResponseTime method used to receive responsetime.
   *
   * @return
   */
  public int getResponsetime() {
    return responsetime;
  }

  /**
   * setResponsetime method used to set the responsetime.
   *
   * @param responsetime — responsetime of the Screen
   */
  public void setResponsetime(int responsetime) {
    this.responsetime = responsetime;
  }
}
