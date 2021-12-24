package field.ryan.rfvhbackend.repositories;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {

  private String id;
  private String name;
  private String email;

  public User() {
  }

  public User(String name, String email) {
    this.setName(name);
    this.setEmail(email);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getId() {
    return id;
  }

}
