package com.yalday.yaldayBoot.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue
  @Column(name = "user_id", unique = true, nullable = false)
  private Long id;

  @Column(name = "user_name")
  private String name;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", user_name='" + name + '\'' +
      ", first_name='" + firstName + '\'' +
      ", last_name='" + lastName + '\'' +
      '}';
  }
}
