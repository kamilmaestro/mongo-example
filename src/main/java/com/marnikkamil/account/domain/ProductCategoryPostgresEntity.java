package com.marnikkamil.account.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Table(name = "product_category")
class ProductCategoryPostgresEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String name;
  @OneToMany
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private Set<ProductPostgresEntity> products;

  private ProductCategoryPostgresEntity() {
  }

  ProductCategoryPostgresEntity(String name, Set<ProductPostgresEntity> products) {
    this.name = name;
    this.products = products;
  }

  @Getter
  static class ProductPostgresEntity {

    private String id;
    @Column(name = "category_id")
    private String categoryId;
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

}
