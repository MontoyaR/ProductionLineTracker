package sample;

public class Widget extends Product {

  Widget() {

  }
  /**
   * Widget constructor used to set the name, manufacturer, and type from the super class, Product.
   *
   * @param name         — name of the Product
   * @param manufacturer — manufacturer for the Product
   * @param type         — type for the Product
   */
  public Widget(String name, String manufacturer, String type) {
    super(name, manufacturer, type);
  }

  /**
   * Widget constructor used to set the id, name, manufacturer, and type from the super class,
   * Product.
   *
   * @param id           — id of the Product
   * @param name         — name of the Product
   * @param manufacturer — manufacturer for the Product
   * @param type         — type for the Product
   */
  public Widget(int id, String name, String manufacturer, String type) {
    super(id, name, manufacturer, type);
  }

  /**
   * Widget constructor used to set the name, and manufacturer from the super class, Product. Also
   * has a field for an ItemType Object.
   *
   * @param name         — name of the Product
   * @param manufacturer — manufacturer for the Product
   * @param itemType     — itemType
   */
  public Widget(String name, String manufacturer, ItemType itemType) {
    super(name, manufacturer);
  }
}
