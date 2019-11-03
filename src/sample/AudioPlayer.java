package sample;

/**
 * Represents an  AudioPlayer that is a subclass of the Product Class and implements
 * MultimediaControl Interface.
 *
 * @author Ricardo Montoya
 */
public class AudioPlayer extends Product implements MultimediaControl {

  /**
   * Private String variables: The mediaType and audioSpecification for AudioPlayer.
   */
  private String audioSpecification;
  private String mediaType;

  /**
   * AudioPlayer constructor sets audioSpecification and mediaType and calls the super class,
   * Product, to receive its name and manufacturer.
   *
   * @param name               — name of Product
   * @param manufacturer       — manufacturer of Product
   * @param audioSpecification — audioSpecification for the AudioPlayer
   * @param mediaType          — mediaType for the AudioPlayer
   */
  AudioPlayer(String name, String manufacturer, String audioSpecification, String mediaType) {
    super(name, manufacturer);
    setAudioSpecification(audioSpecification);
    setMediaType(mediaType);
  }

  /**
   * Gets the audioSpecification of type String.
   *
   * @return
   */
  public String getAudioSpecification() {
    return audioSpecification;
  }

  /**
   * Sets the audioSpecification for AudioPlayer.
   *
   * @param audioSpecification — audioSpecification for the AudioPlayer
   * @return
   */
  public void setAudioSpecification(String audioSpecification) {
    this.audioSpecification = audioSpecification;
  }

  /**
   * Gets MediaType of type String.
   *
   * @return
   */
  public String getMediaType() {
    return this.mediaType;
  }

  /**
   * Sets the MediaType for AudioPlayer.
   *
   * @param mediaType — mediaType for the AudioPlayer
   */
  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  /**
   * This method uses the Override function to change the toString method from the super class,
   * Product.
   *
   * @return
   */
  @Override
  public String toString() {
    super.setType("AUDIO");
    return super.toString() + "\nSupported Audio Formats: " + audioSpecification
        + "\nSupported Playlist Formats: " + mediaType;
  }

  /**
   * Play method used to display "Playing".
   *
   * @return
   */
  public void play() {
    System.out.println("Playing");
  }

  /**
   * Stop method uses to display "Stopping".
   *
   * @return
   */
  public void stop() {
    System.out.println("Stopping");
  }

  /**
   * Previous method used to display "Previous".
   *
   * @return
   */
  public void previous() {
    System.out.println("Previous");
  }

  /**
   * Next method used to display "Next".
   *
   * @return
   */
  public void next() {
    System.out.println("Next");
  }
}
