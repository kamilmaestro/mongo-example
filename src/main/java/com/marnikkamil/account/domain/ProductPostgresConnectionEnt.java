package com.marnikkamil.account.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

interface ProductPostgresConnectionEnt extends JpaRepository<ProductCategoryPostgresEntity.ProductPostgresEntity, Long>  {

  @Query(value = "SELECT * FROM product p " +
      "WHERE p.name LIKE('%lastik%') AND p.price >= 888 AND p.price <= 889", nativeQuery = true)
  Collection<ProductCategoryPostgresEntity.ProductPostgresEntity> searchProducts(String text, double minPrice, double maxPrice);

}
