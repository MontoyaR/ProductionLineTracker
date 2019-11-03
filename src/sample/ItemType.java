package sample;

/**
 * ItemType is an Enum, representing a fixed set of special objects.
 *
 * @author Ricardo Montoya
 */
public enum ItemType {
  AUDIO("AU"), VISUAL("VI"), AUDIO_MOBILE("AM"), VISUAL_MOBILE("VM");

  private String label;

  /**
   * ItemType constructor used to set the label.
   *
   * @param label — label of the ItemType
   */
  ItemType(String label) {
    this.label = label;
  }

  /**
   * Gets the label variable.
   *
   * @return
   */
  public String getLabel() {
    return label;
  }

  /**
   * Sets the label variable.
   *
   * @param label — label of the ItemType
   * @return
   */
  public void setLabel(String label) {
    this.label = label;
  }
}
