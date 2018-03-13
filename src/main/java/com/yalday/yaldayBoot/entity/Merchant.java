package com.yalday.yaldayBoot.entity;


import javax.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
/**
 * Created by Home on 11/03/2018.
 */
@Entity
@Table(name = "Merchant")
@EntityListeners(AuditingEntityListener.class)
public class Merchant {

  @Id
  @GeneratedValue
  @Column(name = "merch_id", unique = true, nullable = false)
  private Long id;

  @Column(name="merch_name")
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

