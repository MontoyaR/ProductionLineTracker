package sample;

public class Screen implements ScreenSpec {
  String resolution;
  int refreshrate;
  int responsetime;

  public Screen(String resolution, int refreshrate, int responsetime) {
    setResolution(resolution);
    setRefreshrate(refreshrate);
    setResponsetime(responsetime);
  }

  @Override
  public String toString() {
    return "\nResolution: " + resolution
        + "\nRefresh rate: " + refreshrate + "\nResponse time: " + responsetime;
  }

  @Override
  public String getResolution() {
    return resolution;
  }

  @Override
  public int getRefreshRate() {
    return refreshrate;
  }

  @Override
  public int getResponseTime() {
    return responsetime;
  }

  public void setResolution(String resolution) {
    this.resolution = resolution;
  }

  public int getRefreshrate() {
    return refreshrate;
  }

  public void setRefreshrate(int refreshrate) {
    this.refreshrate = refreshrate;
  }

  public int getResponsetime() {
    return responsetime;
  }

  public void setResponsetime(int responsetime) {
    this.responsetime = responsetime;
  }

}
