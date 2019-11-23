package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
  StringBuilder Name;
  String name;
  String username;
  String password;
  String email;

  Employee(String name, String password) {

    if (checkName(name)) {
      String segments[] = name.split(" ");
      setUsername(name.substring(0, 1).toLowerCase() + segments[1].toLowerCase());
      setEmail(segments[0].toLowerCase() + "." + segments[1]
          .toLowerCase() + "@oracleacademy.Test");
      this.name = name;
    } else {
      setUsername("default");
      setEmail("user@oracleacademy.Test");
    }

    if (isValidPassword(password)) {
      setPassword(password);
      this.password = password;
    } else {
      setPassword("pw");
    }
  }




  /**
   * checkName method will check if the string name (first last) has:
   * Only one space, any lowercase or uppercase letters .
   *
   * @param name
   * @return
   */
  private boolean checkName(String name) {
    return name.matches("^[a-zA-Z]+\\s[a-zA-Z]+$");
  }


  private boolean isValidPassword(String password){
    return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).*$");
  }



  /**
   *
   * @param email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  public void setUsername(String name) {

    this.username = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}
