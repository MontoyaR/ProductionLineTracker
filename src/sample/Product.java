package sample;

public abstract class Product implements Item {

  private int Id;
  private String type;
  private String manufacturer;
  private String name;

  public void getId(){
    return;
  }

  public void setName(String n){
    this.name = n;
  }

  public void getName(){
    return;
  }

  public void setManufacturer(String m){
    this.manufacturer = m;
  }

  public void getManufacturer(){
    return;
  }
}
