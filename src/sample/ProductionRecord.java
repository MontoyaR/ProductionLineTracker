package sample;

import java.util.Date;

/**
 * Represent a Production Record.
 *
 * @author Ricardo Montoya
 */
public class ProductionRecord {

  /**
   * Variables used to represent the Production Record.
   */
  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;


  /**
   * ProductionRecord constructor that sets the default values.
   *
   * @param productID — id for the Product
   */
  ProductionRecord(int productID) {
    setProductionNum(0);
    setSerialNum("0");
    setProdDate(new Date());
  }

  /**
   * ProductionRecord constructor that sets the productionNumber, productID, serialNumber, and
   * dateProduced.
   *
   * @param productionNumber — productionNumber for the Product
   * @param productID        — id for the Product
   * @param serialNumber     — serialNumber for the Product
   * @param dateProduced     — dateProduced for the Product
   */
  ProductionRecord(int productionNumber, int productID, String serialNumber, Date dateProduced) {
    setProductionNum(productionNumber);
    setProductID(productID);
    setSerialNum(serialNumber);
    setProdDate(dateProduced);
  }

  /**
   * ProductionRecord constructor that sets the serialNumber and dateProduced.
   *
   * @param productProduced — productProduced of the Product
   * @param itemCount       — itemCount for the array
   */
  ProductionRecord(Product productProduced, int itemCount) {
    setSerialNum(
        productProduced.getManufacturer().substring(0, 3) + ItemType.AUDIO.getLabel() + "0000"
            + itemCount);
    setProdDate(new Date());
  }

  /**
   * toString super method used to display the productionNumber, productID, serialNumber, and the
   * dateProduced to the console.
   *
   * @return
   */
  @Override
  public String toString() {
    return "Prod. Num: " + productionNumber + " Product ID: " + productID + " Serial Num: "
        + serialNumber + " Date: " + dateProduced;
  }

  /**
   * getProductionNum method used to receive productionNumber.
   *
   * @return
   */
  public int getProductionNum() {
    return productionNumber;
  }

  /**
   * setProductionNum method used to set the productionNumber.
   *
   * @param productionNumber — ProductionNumber for the Product
   */
  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /**
   * getProductID method used to receive productID.
   *
   * @return
   */
  public int getProductID() {
    return productID;
  }

  /**
   * setProductID method used to set the productID.
   *
   * @param productID — id for the Product
   */
  public void setProductID(int productID) {
    this.productID = productID;
  }

  /**
   * getSerialNum method used to receive serialNumber.
   *
   * @return
   */
  public String getSerialNum() {
    return serialNumber;
  }

  /**
   * setSerialNum method used to set the serialNumber.
   *
   * @param serialNumber — serialNumber for the Product
   */
  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * getProdDate method used to receive dateProduced.
   *
   * @return
   */
  public Date getProdDate() {
    return dateProduced;
  }

  /**
   * setProdDate method used to set the dateProduced.
   *
   * @param dateProduced — dateProduced for the Product
   */
  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
  }
}
