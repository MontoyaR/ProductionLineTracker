package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {

  StringBuilder name;
  String username;
  String password;
  String email;

  Employee(String name, String password) {

  }


  private void setName(StringBuilder name) {
    this.name = name;
  }

  //setUsername will set the username field to the first initial of the first name and then the last name, all lowercase.
  private void setUsername(String username) {
    this.username = username;
  }

  private void createUsername(StringBuilder name) {
    this.name = name;
  }

//  private boolean checkName(StringBuilder name) {
//
//    //check if the name contains a space. If it does, it will call setUsername and setEmail, passing
//    // the name in to both. If it doesn't contain a space, set the username to "default" and the
//    // email to "user@oracleacademy.Test"
//
//  }
}
