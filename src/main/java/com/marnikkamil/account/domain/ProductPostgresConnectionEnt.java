package com.marnikkamil.account.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
interface ProductPostgresConnectionEnt extends JpaRepository<ProductPostgresEntity, UUID>  {

  @Query(value = "SELECT * FROM product p " +
      "WHERE p.name LIKE('%lastik%') AND p.price >= 888 AND p.price <= 889", nativeQuery = true)
  Collection<ProductPostgresEntity> searchProducts(String text, double minPrice, double maxPrice);

}
