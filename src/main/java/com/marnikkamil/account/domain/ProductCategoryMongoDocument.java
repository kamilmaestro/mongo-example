package com.marnikkamil.account.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.HashSet;
import java.util.Set;

@Document("product_category")
class ProductCategoryMongoDocument {

  @MongoId
  private ObjectId id;
  private String name;
  private Set<ProductMongoDocument> products;

  private ProductCategoryMongoDocument() {
  }

  ProductCategoryMongoDocument(String name, Set<ProductMongoDocument> products) {
    this.name = name;
    this.products = products;
  }

  ProductCategoryMongoDocument(ObjectId id, String name) {
    this.id = id;
    this.name = name;
    this.products = new HashSet<>();
  }

  ObjectId getId() {
    return id;
  }

  String getName() {
    return name;
  }

  Set<ProductMongoDocument> getProducts() {
    return products;
  }

  static class ProductMongoDocument {

    private String id;
    private String name;
    private Integer amount;
    private double price;

    private ProductMongoDocument() {
    }

    ProductMongoDocument(String name, Integer amount, double price) {
      this.name = name;
      this.amount = amount;
      this.price = price;
    }

    public String getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public Integer getAmount() {
      return amount;
    }

    public double getPrice() {
      return price;
    }

  }

}
