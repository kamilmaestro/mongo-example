package com.marnikkamil.account.domain;

import com.marnikkamil.account.dto.ImportedProducts;
import com.marnikkamil.account.dto.ProductCategoryDto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

final class ProductCategory {

  private String id;
  private final String categoryName;
  private final Set<Product> products;

  ProductCategory(String categoryName) {
    this.categoryName = categoryName;
    this.products = new HashSet<>();
  }

  public ProductCategory(String id, String categoryName, Set<Product> products) {
    this.id = id;
    this.categoryName = categoryName;
    this.products = products;
  }

  public ProductCategory(String categoryName, Collection<ImportedProducts.ProductDto> products) {
    this.categoryName = categoryName;
    this.products = products.stream()
        .map(product -> new Product(product.getName(), product.getAmount(), product.getPrice()))
        .collect(Collectors.toSet());
  }

  ProductCategoryDto dto() {
    return ProductCategoryDto.builder()
        .id(id)
        .accountName(categoryName)
        .build();
  }

  String getId() {
    return id;
  }

  String getCategoryName() {
    return categoryName;
  }

  Set<Product> getProducts() {
    return products;
  }

}
