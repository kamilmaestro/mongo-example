package com.marnikkamil.account.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@Qualifier("postgres")
class ProductPostgresRepository implements ProductRepository {

  @Autowired
  ProductPostgresConnection dbConnection;

  @Override
  public ProductCategory save(ProductCategory productCategory) {
    final ProductCategoryPostgresEntity categoryPostgresEntity = dbConnection.save(convertToEntity(productCategory));
    return toDomain(categoryPostgresEntity);
  }

  private ProductCategoryPostgresEntity convertToEntity(ProductCategory productCategory) {
    final Set<ProductCategoryPostgresEntity.ProductPostgresEntity> products = productCategory.getProducts().stream()
        .map(product -> new ProductCategoryPostgresEntity.ProductPostgresEntity(product.getName(), product.getAmount(), product.getPrice()))
        .collect(Collectors.toSet());

    return new ProductCategoryPostgresEntity(productCategory.getCategoryName(), products);
  }

  private ProductCategory toDomain(ProductCategoryPostgresEntity entity) {
    final Set<Product> products = entity.getProducts().stream()
        .map(product -> new Product(product.getId(), product.getName(), product.getAmount(), product.getPrice()))
        .collect(Collectors.toSet());

    return new ProductCategory(entity.getId(), entity.getName(), products);
  }

}
