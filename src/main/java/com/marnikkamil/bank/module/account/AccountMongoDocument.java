package com.marnikkamil.bank.module.account;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.HashSet;
import java.util.Set;

@Document("account")
class AccountMongoDocument {

  @MongoId
  private ObjectId id;
  private String name;
  private Set<Share> shares = new HashSet<>();

  private AccountMongoDocument() {
  }

  AccountMongoDocument(String name) {
    this.name = name;
  }

  AccountMongoDocument(ObjectId id, String name) {
    this.id = id;
    this.name = name;
  }

  public ObjectId getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  static class Share {

    private final String companyId;
    private final float percentage;

    Share(String companyId, float percentage) {
      this.companyId = companyId;
      this.percentage = percentage;
    }

  }

}
