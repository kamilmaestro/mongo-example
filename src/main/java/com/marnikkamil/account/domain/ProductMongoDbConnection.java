package com.marnikkamil.account.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProductMongoDbConnection extends MongoRepository<ProductCategoryMongoDocument, ObjectId> {

}