package sample;

/**
 * ScreenSpec is an Interface used as a reference type.
 *
 * @author Ricardo Montoya
 */
public interface ScreenSpec {

  /**
   * Constant method signatures.
   *
   * @return
   */
  public String getResolution();

  public int getRefreshRate();

  public int getResponseTime();
}
