package org.loginform.usersdata;

import java.util.HashMap;
import java.util.Map;

public class UserAccounts {

  public static Map<String, User> users;

  static {
    users = new HashMap<>();
    User admin = new User("Shawn", "admin", "admin");
    users.put(admin.getLogin(), admin);
    User root = new User("Jack", "root", "toor");
    users.put(root.getLogin(), root);
    User user = new User("John", "user", "pass");
    users.put(user.getLogin(), user);
  }
}
