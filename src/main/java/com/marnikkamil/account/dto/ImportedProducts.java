package com.marnikkamil.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;

@Getter
@AllArgsConstructor
public final class ImportedProducts {
  Collection<ProductCategoryDto> productCategories;

  @Getter
  @AllArgsConstructor
  public static final class ProductCategoryDto {
    String name;
    Collection<ProductDto> products;
  }

  @Getter
  @AllArgsConstructor
  public static final class ProductDto {
    String name;
    Integer amount;
    double price;
  }
}
