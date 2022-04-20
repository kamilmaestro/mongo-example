package com.marnikkamil.bank.module.account;

import com.marnikkamil.bank.infrastructure.account.AccountDto;
import org.bson.types.ObjectId;

import java.util.UUID;

final class Account {

  private String id;
  private final String accountName;

  Account(String accountName) {
    this.accountName = accountName;
  }

  public Account(String id, String accountName) {
    this.id = id;
    this.accountName = accountName;
  }

  AccountDto dto() {
    return AccountDto.builder()
        .id(id)
        .accountName(accountName)
        .build();
  }

  String getId() {
    return id;
  }

  String getAccountName() {
    return accountName;
  }

}
