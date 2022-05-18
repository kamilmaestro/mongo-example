package com.marnikkamil.account.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
interface ProductPostgresConnection extends JpaRepository<ProductCategoryPostgresEntity, String> {

//  @Query(value = "SELECT c FROM ProductCategoryPostgresEntity c " +
//      "INNER JOIN FETCH ProductCategoryPostgresEntity.ProductPostgresEntity p ON c.id = p.productCategoryId " +
//      "WHERE p.name LIKE CONCAT('%','lastik','%') AND p.price >= 888 AND p.price <= 889")
  @Query(value = "SELECT DISTINCT c.id, c.name FROM product_category c INNER JOIN product p ON c.id = p.product_category_id " +
      "WHERE p.name LIKE('%lastik%') AND p.price >= 888 AND p.price <= 889", nativeQuery = true)
  Collection<ProductCategoryPostgresEntity> search(String text, double minPrice, double maxPrice);

  @Query(value = "SELECT * FROM product p " +
      "WHERE p.name LIKE('%lastik%') AND p.price >= 888 AND p.price <= 889", nativeQuery = true)
  Collection<ProductCategoryPostgresEntity.ProductPostgresEntity> searchProducts(String text, double minPrice, double maxPrice);

//  @Query(value = "SELECT p FROM product_category c INNER JOIN product p ON c.id = p.product_category_id " +
//      "WHERE p.name LIKE('%lastik%') AND p.price >= 888 AND p.price <= 889", nativeQuery = true)
//  Collection<ProductCategoryPostgresEntity.ProductPostgresEntity> searchProducts(String text, double minPrice, double maxPrice);

}
