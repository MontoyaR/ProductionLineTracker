package sample;

/**
 * Represents a Product that is the super class and implements the Item Interface.
 *
 * @author Ricardo Montoya
 */
public abstract class Product implements Item {

  /**
   * Private variables.
   */
  private int Id;
  private String Type;
  private String Manufacturer;
  private String Name;

  /**
   * Constructor used by Widget through inheritance for Product creation for the ObservableList.
   */
  Product() {

  }

  /**
   * Product constructor used to set the name, manufacturer, and type variables.
   *
   * @param name         — name of the Product
   * @param manufacturer — manufacturer for the Product
   * @param type         — type for the Product
   */
  Product(String name, String manufacturer, String type) {
    this.Name = name;
    this.Manufacturer = manufacturer;
    this.Type = type;
  }

  /**
   * Product constructor used to set the name and manufacturer variables.
   *
   * @param name         — name of the Product
   * @param manufacturer — manufacturer for the Product
   */
  Product(String name, String manufacturer) {
    this.Name = name;
    this.Manufacturer = manufacturer;
  }

  /**
   * Product constructor used to set the id, name, manufacturer, and type variables.
   *
   * @param id           — id of the Product
   * @param name         — name of the Product
   * @param manufacturer — manufacturer for the Product
   * @param type         — type for the Product
   */
  Product(int id, String name, String manufacturer, String type) {
    this.Id = id;
    this.Name = name;
    this.Manufacturer = manufacturer;
    this.Type = type;
  }

  /**
   * toString super method used to display the Name, Manufacturer, and Type to the console.
   *
   * @return
   */
  public String toString() {
    return "Name: " + Name + "\n" + "Manufacturer: " + Manufacturer + "\n" + "Type: " + Type;
  }

  /**
   * getId method used to receive the Id variable.
   *
   * @return
   */
  public int getId() {
    return Id;
  }

  /**
   * getManufacturer method used to receive the Manufacturer variable.
   *
   * @return
   */
  public String getManufacturer() {
    return Manufacturer;
  }

  /**
   * setManufacturer method used to set the Manufacturer variable.
   *
   * @param manufacturer — manufacturer for the Product
   */
  public void setManufacturer(String manufacturer) {
    Manufacturer = manufacturer;
  }

  /**
   * getName method used to receive the Name variable.
   *
   * @return
   */
  public String getName() {
    return Name;
  }

  /**
   * setName method used to set the Name variable.
   *
   * @param name — name of the Product
   */
  public void setName(String name) {
    Name = name;
  }

  /**
   * setId method used to set the Id variable.
   *
   * @param id — id of the Product
   */
  public void setId(int id) {
    Id = id;
  }

  /**
   * getType method used to receive the Type variable.
   *
   * @return
   */
  public String getType() {
    return Type;
  }

  /**
   * setType method used to set the Type variable.
   *
   * @param type — type for the Product
   */
  public void setType(String type) {
    Type = type;
  }
}

/**
 * Represents a Widget that is a subclass of the Product Class.
 *
 * @author Ricardo Montoya
 */
class Widget extends Product {

  /**
   * Constructor used for creation of new Product for the ObservableList.
   */
  Widget()  {

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
