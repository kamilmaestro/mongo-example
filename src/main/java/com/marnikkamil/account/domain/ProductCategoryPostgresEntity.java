package com.marnikkamil.account.domain;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Entity
@Table(name = "product_category")
class ProductCategoryPostgresEntity {

  @Id
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
  private UUID id;
  private String name;
  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "product_category_id")
  private Set<ProductPostgresEntity> products;

  private ProductCategoryPostgresEntity() {
  }

  ProductCategoryPostgresEntity(String name, Set<ProductPostgresEntity> products) {
    this.name = name;
    this.products = products;
  }

//  @Getter
//  @Entity
//  @Table(name = "product")
//  static class ProductPostgresEntity {
//
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
//    @Id
//    @Type(type="uuid-char")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
//    private UUID id;
//    private String name;
//    private Integer amount;
//    private double price;
//
//    private ProductPostgresEntity() {
//    }
//
//    ProductPostgresEntity(String name, Integer amount, double price) {
//      this.name = name;
//      this.amount = amount;
//      this.price = price;
//    }
//
//  }

}
