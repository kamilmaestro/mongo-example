package com.marnikkamil.account.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
interface ProductPostgresConnection extends JpaRepository<ProductCategoryPostgresEntity, String> {

//  @Query(value = "SELECT c FROM ProductPostgresEntity c INNER JOIN ProductPostgresEntity p " +
//      "WHERE p.name LIKE CONCAT('%','lastik','%') AND p.price >= 888 AND p.price <= 889")
  Collection<ProductCategoryPostgresEntity> search(String text, double minPrice, double maxPrice);

}
