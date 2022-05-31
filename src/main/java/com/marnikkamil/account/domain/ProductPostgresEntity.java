package com.marnikkamil.account.domain;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Entity
@Table(name = "product")
class ProductPostgresEntity {

  @Id
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
  private UUID id;
  private String name;
  private Integer amount;
  private double price;

  private ProductPostgresEntity() {
  }

  ProductPostgresEntity(String name, Integer amount, double price) {
    this.name = name;
    this.amount = amount;
    this.price = price;
  }

}