package com.marnikkamil.bank.module.account;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

@Document("account")
class AccountMongoEntity {

  @Id
  private ObjectId id;
  private String name;

  private AccountMongoEntity() {
  }

  AccountMongoEntity(String name) {
    this.name = name;
  }

  AccountMongoEntity(ObjectId id, String name) {
    this.id = id;
    this.name = name;
  }

  public ObjectId getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}
