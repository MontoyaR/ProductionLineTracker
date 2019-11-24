package sample;

/**
 * Represent an Employee that will allow the user to input their full name and then create a user id
 * of their first name, a period, and then their surname, an email address of their first initial
 * and last name.
 *
 * @author Ricardo Montoya
 */
public class Employee {

  /**
   * Private variables.
   */
  private String name;
  private String username;
  private String password;
  private String email;


  /**
   * Employee constructor used to set name, email, and password.
   *
   * @param name     — name of the Employee.
   * @param password — password of the Employee.
   */
  Employee(String name, String password) {
    this.name = name;
    if (checkName(name)) {
      String[] segments = name.split(" ");
      setUsername(name.substring(0, 1).toLowerCase() + segments[1].toLowerCase());
      setEmail(segments[0].toLowerCase() + "." + segments[1]
          .toLowerCase() + "@oracleacademy.Test");

    } else {
      setUsername("default");
      setEmail("user@oracleacademy.Test");
    }

    if (isValidPassword(password)) {
      setPassword(password);
    } else {
      setPassword("pw");
    }

    reverseString(password);
  }


  /**
   * checkName method will check if the string name (first last) has only one space, any lowercase
   * or uppercase letters.
   *
   * @param name — name of the Product.
   * @return boolean — boolean value based on regular expression.
   */
  private boolean checkName(String name) {
    return name.matches("^[a-zA-Z]+\\s[a-zA-Z]+$");
  }

  /**
   * isValidPassword boolean method used to determine if the password contains at least one
   * lowercase letter, one uppercase letter, and special character.
   *
   * @param password — password of the Employee.
   * @return boolean — boolean value based on regular expression.
   */
  private boolean isValidPassword(String password) {
    return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#$%^&+=])(?=\\S+$).*$");
  }

  /**
   * toString method used to override the toString method.
   *
   * @return String — String used to override the toString method.
   */
  @Override
  public String toString() {
    return "Employee Details\n" + "Name: " + name + "\n" + "Username: " + username + "\n"
        + "Email: " + email + "\n" + "Initial Password: " + password;
  }

  /**
   * Method used to reverse the password.
   *
   * @param password — password of the Employee.
   * @return StringBuilder — reversed.
   */
  public String reverseString(String password) {

    StringBuilder reverse = new StringBuilder(password);

    reverse.reverse();

    return reverse.toString();

  }

  /**
   * setEmail setter method used to set the email variable.
   *
   * @param email — email of the Employee.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * setUsername setter method used to set the username variable.
   *
   * @param name — name of the Employee.
   */
  public void setUsername(String name) {

    this.username = name;
  }

  /**
   * setPassword setter method used to set the password of the Employee.
   *
   * @param password — password of the Employee.
   */
  public void setPassword(String password) {
    this.password = password;
  }
}
