package com.yalday.yaldayBoot.entity;


import javax.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "merchant")
public class Merchant {

  @Id
  @GeneratedValue
  @Column(name = "merchant_id", unique = true, nullable = false)
  private Long id;

  @Column(name="merchant_name")
  private String name;

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

  public String toString() {
    return "merch_id= " + id + ", merchanName=" + name ;
  }


}

