package com.marnikkamil.account.domain;

import com.marnikkamil.account.dto.SearchProductsDto;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Qualifier("postgres")
class ProductPostgresRepository implements ProductRepository {

  @Autowired
  ProductPostgresConnection productCategoryDbConnection;
  @Autowired
  ProductPostgresConnectionEnt productDbConnection;

  @Override
  public ProductCategory save(ProductCategory productCategory) {
    final ProductCategoryPostgresEntity categoryPostgresEntity = productCategoryDbConnection.save(convertToEntity(productCategory));
    return toDomain(categoryPostgresEntity);
  }

  @Override
  public ProductCategory findById(String id) {
    final UUID uuid = UUID.fromString(id);
    return productCategoryDbConnection.findById(uuid)
        .map(this::toDomain)
        .orElseThrow(EntityNotFoundException::new);
  }


  @Override
  public Collection<Product> search(SearchProductsDto searchProducts) {
    final Collection<ProductPostgresEntity> search2 = productDbConnection
        .searchProducts(searchProducts.getText(), searchProducts.getMinPrice(), searchProducts.getMaxPrice()).stream().distinct().collect(Collectors.toList());
    return search2.stream().map(this::productToDomain).collect(Collectors.toList());
  }

  private Product productToDomain(ProductPostgresEntity product) {
    return new Product(product.getId().toString(), product.getName(), product.getAmount(), product.getPrice());
  }

  private ProductCategoryPostgresEntity convertToEntity(ProductCategory productCategory) {
    final Set<ProductPostgresEntity> products = productCategory.getProducts().stream()
        .map(product -> new ProductPostgresEntity(product.getName(), product.getAmount(), product.getPrice()))
        .collect(Collectors.toSet());

    return new ProductCategoryPostgresEntity(productCategory.getCategoryName(), products);
  }

  private ProductCategory toDomain(ProductCategoryPostgresEntity entity) {
    final Set<Product> products = entity.getProducts().stream()
        .map(product -> new Product(product.getId().toString(), product.getName(), product.getAmount(), product.getPrice()))
        .collect(Collectors.toSet());

    return new ProductCategory(entity.getId().toString(), entity.getName(), products);
  }

}
