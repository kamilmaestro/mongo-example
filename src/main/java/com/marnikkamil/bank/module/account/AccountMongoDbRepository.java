package com.marnikkamil.bank.module.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mongo")
class AccountMongoDbRepository implements AccountRepository {

  @Autowired
  AccountMongoDbRepositoryImpl accountRepository;

  @Override
  public Account save(Account account) {
    final AccountMongoEntity accountMongoEntity = accountRepository
        .save(new AccountMongoEntity(account.getAccountName()));

    return new Account(accountMongoEntity.getId().toString(), accountMongoEntity.getName());
  }

}
