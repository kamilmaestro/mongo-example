package com.marnikkamil.bank.module.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AccountConfiguration {

  @ConditionalOnProperty(name = "database.type", havingValue = "postgres")
  @Bean
  AccountFacade accountFacadePostgres(@Qualifier("postgres") AccountRepository accountRepository) {
    return new AccountFacade(accountRepository);
  }

  @ConditionalOnProperty(name = "database.type", havingValue = "mongo")
  @Bean
  AccountFacade accountFacadeMongo(@Qualifier("mongo") AccountRepository accountRepository) {
    return new AccountFacade(accountRepository);
  }

//  @Bean
//  AccountFacade accountFacade(@Qualifier(type) AccountRepository accountRepository) {
//    return new AccountFacade(accountRepository);
//  }

  //todo tu zrobic wstrzykneicie repo poprzez qualifier, pobrac z piku properties,
  // jesli a to qualifier dla mongo, jesli b to qualifier dla postgresa

}
