package com.marnikkamil.account.domain;

final class Product {

  private String id;
  private final String name;
  private final Integer amount;
  private final double price;

  public Product(String name, Integer amount, double price) {
    this.name = name;
    this.amount = amount;
    this.price = price;
  }

  public Product(String id, String name, Integer amount, double price) {
    this.id = id;
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
