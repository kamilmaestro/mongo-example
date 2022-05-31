package com.marnikkamil.account.domain;

import com.marnikkamil.account.dto.SearchProductsDto;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Qualifier("mongo")
class ProductMongoDbRepository implements ProductRepository {

  @Autowired
  ProductMongoDbConnection dbConnection;

  @Override
  public ProductCategory save(ProductCategory productCategory) {
    final ProductCategoryMongoDocument productMongoDocument = dbConnection.save(convertToMongoDocument(productCategory));
    return convertToDomain(productMongoDocument);
  }

  @Override
  public ProductCategory findById(String id) {
    final ObjectId objectId = new ObjectId(id);
    return dbConnection.findById(objectId)
        .map(this::convertToDomain)
        .orElseThrow(EntityNotFoundException::new);
  }

  @Override
  public Collection<Product> search(SearchProductsDto searchProducts) {
    final Collection<ProductCategoryMongoDocument> search = dbConnection
        .search(searchProducts.getText(), searchProducts.getMinPrice(), searchProducts.getMaxPrice());

    return search.stream()
        .map(category -> category.getProducts().stream().map(this::productToDomain).collect(Collectors.toList()))
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  private Product productToDomain(ProductCategoryMongoDocument.ProductMongoDocument product) {
    return new Product(product.getId(), product.getName(), product.getAmount(), product.getPrice());
  }

  private ProductCategoryMongoDocument convertToMongoDocument(ProductCategory productCategory) {
    final Set<ProductCategoryMongoDocument.ProductMongoDocument> products = productCategory.getProducts().stream()
        .map(product -> new ProductCategoryMongoDocument.ProductMongoDocument(product.getName(), product.getAmount(), product.getPrice()))
        .collect(Collectors.toSet());

    return new ProductCategoryMongoDocument(productCategory.getCategoryName(), products);
  }

  private ProductCategory convertToDomain(ProductCategoryMongoDocument document) {
    final Set<Product> products = document.getProducts().stream()
        .map(product -> new Product(product.getId(), product.getName(), product.getAmount(), product.getPrice()))
        .collect(Collectors.toSet());

    return new ProductCategory(document.getId().toString(), document.getName(), products);
  }

}
