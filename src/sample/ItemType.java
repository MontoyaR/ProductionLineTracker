package sample;

/**
 *
 */
public enum ItemType {
  AUDIO("AU"), VISUAL("VI"), AUDIO_MOBILE("AM"), VISUAL_MOBILE("VM");

  private String label;
  ItemType(String c){
    label = c;
  }
}
