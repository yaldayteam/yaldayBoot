package com.yalday.yaldayBoot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "merchant")
public class Merchant {

  @Id
  @GeneratedValue
  @Column(name = "merchant_id", unique = true, nullable = false)
  private Long id;

  @Column(name="merchant_name")
  private String name;

  @Column(name="image_url")
  private String imageUrl;

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

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  @Override
  public String toString() {
    return "Merchant{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", imageUrl='" + imageUrl + '\'' +
      '}';
  }
}

