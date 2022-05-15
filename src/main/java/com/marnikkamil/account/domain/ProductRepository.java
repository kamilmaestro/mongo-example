package com.marnikkamil.account.domain;

import com.marnikkamil.account.dto.SearchProductsDto;

import java.util.Collection;

interface ProductRepository {

  ProductCategory save(ProductCategory productCategory);

  Collection<Product> search(SearchProductsDto searchProducts);

}
