package com.example.j2eedemo.model;

public class Person {
  private long id;
  private String name;
  private String email;

  public Person() {
  }

  public Person(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Person(long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  // getters & setters
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
