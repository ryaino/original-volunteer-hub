package com.ryan.rfvhbackend.volunteers;

/**
 * POJO that represents all fields of a document within the volunteers
 * collection
 *
 * @author Ryan Field (fieldryan19@gmail.com)
 */
public class Volunteer {

  private String name;
  private String email;

  public Volunteer() {
  }

  public Volunteer(String name, String email) {
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

}
