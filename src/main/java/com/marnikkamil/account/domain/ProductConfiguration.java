package com.marnikkamil.account.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ProductConfiguration {

  @ConditionalOnProperty(name = "database.type", havingValue = "postgres")
  @Bean
  ProductFacade productFacadePostgres(@Qualifier("postgres") ProductRepository productRepository) {
    return new ProductFacade(productRepository);
  }

  @ConditionalOnProperty(name = "database.type", havingValue = "mongo")
  @Bean
  ProductFacade productFacadeMongo(@Qualifier("mongo") ProductRepository productRepository) {
    return new ProductFacade(productRepository);
  }

//  @Bean
//  AccountFacade accountFacade(@Qualifier(type) AccountRepository accountRepository) {
//    return new AccountFacade(accountRepository);
//  }

  //todo tu zrobic wstrzykneicie repo poprzez qualifier, pobrac z piku properties,
  // jesli a to qualifier dla mongo, jesli b to qualifier dla postgresa

}
