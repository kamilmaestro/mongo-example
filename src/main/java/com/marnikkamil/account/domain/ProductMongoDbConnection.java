package com.marnikkamil.account.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
interface ProductMongoDbConnection extends MongoRepository<ProductCategoryMongoDocument, ObjectId> {

  @Query(value = "{ \"products.name\" : /lastik/, \"products.price\": { $gte: 888}, \"products.price\": { $lte: 889} }")
  Collection<ProductCategoryMongoDocument> search(String text, double minPrice, double maxPrice);

}