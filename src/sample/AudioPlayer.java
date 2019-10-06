package sample;

public class AudioPlayer extends Product implements MultimediaControl {

  String audioSpecification;
  String mediaType;


  public String getAudioSpecification() {
    return audioSpecification;
  }

  public void setAudioSpecification(String audioSpecification) {
    this.audioSpecification = audioSpecification;
  }

  public String getMediaType() {
    return mediaType;
  }

  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  AudioPlayer(String name, String manufacturer, String audioSpecification, String mediaType) {
    super(name, manufacturer);


  }

  @Override
  public String toString() {

    return super.toString() +"\nAudio: " + "\nSupported Audio Formats:" + "\nSupported Playlist Formats:";
  }

  public void play() {

    System.out.println("Playing");
  }


  public void stop() {

    System.out.println("Stopped");
  }


  public void previous() {

    System.out.println("Previous");
  }


  public void next() {

    System.out.println("Next");
  }
}
