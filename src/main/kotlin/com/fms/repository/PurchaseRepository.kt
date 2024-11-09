package com.fms.repository

import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository
import com.fms.model.Purchase

@MongoRepository
interface PurchaseRepository : CrudRepository<Purchase, String>