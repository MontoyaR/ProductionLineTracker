package sample;

/**
 * Item is an interface used as a reference type.
 *
 * @author Ricardo Montoya
 */
public interface Item {

  /**
   * Constant method signatures.
   */
  int getId();

  void setName(String name);

  String getName();

  void setManufacturer(String manufacturer);

  String getManufacturer();

}
