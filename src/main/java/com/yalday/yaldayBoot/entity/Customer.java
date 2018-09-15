package com.yalday.yaldayBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

  @Id
  @GeneratedValue
  @Column(name = "user_id", unique = true, nullable = false)
  private Long id;

  @Column(name = "user_name")
  private String username;

  @Column(name = "password")
  private String password;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Customer{" +
      "id=" + id +
      ", username='" + username + '\'' +
      '}';
  }
}
