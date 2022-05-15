package com.marnikkamil.account.domain;

import com.marnikkamil.account.dto.ImportedProducts;
import com.marnikkamil.account.dto.ProductCategoryDto;
import com.marnikkamil.account.dto.ProductDto;
import com.marnikkamil.account.dto.SearchProductsDto;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public final class ProductFacade {

  ProductRepository productRepository;

  public Collection<ProductCategoryDto> importProducts(ImportedProducts importedProducts) {
    final List<ProductCategory> productCategories = importedProducts.getProductCategories().stream()
        .map(category -> new ProductCategory(category.getName(), category.getProducts()))
        .collect(Collectors.toList());

    return productCategories.stream()
        .map(product -> productRepository.save(product))
        .map(ProductCategory::dto)
        .collect(Collectors.toList());
  }

  public Collection<ProductDto> searchProducts(SearchProductsDto searchProducts) {
    final Collection<Product> search = productRepository.search(searchProducts);
    return search.stream()
        .map(Product::dto)
        .collect(Collectors.toList());
  }

}
