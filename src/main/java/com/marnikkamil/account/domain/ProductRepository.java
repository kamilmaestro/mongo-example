package com.marnikkamil.account.domain;

import com.marnikkamil.account.dto.SearchProductsDto;

import java.util.Collection;
import java.util.Optional;

interface ProductRepository {

  ProductCategory save(ProductCategory productCategory);

  ProductCategory findById(String id);

  Collection<Product> search(SearchProductsDto searchProducts);

}
