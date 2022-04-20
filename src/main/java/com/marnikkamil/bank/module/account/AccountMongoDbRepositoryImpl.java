package com.marnikkamil.bank.module.account;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AccountMongoDbRepositoryImpl extends MongoRepository<AccountMongoDocument, ObjectId> {

}