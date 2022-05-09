package com.marnikkamil.account.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProductPostgresConnection extends JpaRepository<ProductCategoryPostgresEntity, String> {

}
