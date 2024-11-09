package com.fms.service

import com.fms.infrastructure.MetricsRegistry
import com.fms.infrastructure.MetricsRegistry.Companion.PURCHASE_COUNTER
import com.fms.infrastructure.MetricsRegistry.Companion.TAG_STORE
import com.fms.model.Purchase
import com.fms.repository.PurchaseRepository
import jakarta.inject.Singleton
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Singleton
class PurchaseService(
    private val repository: PurchaseRepository,
    private val metricsRegistry: MetricsRegistry
) {
    private val logger: Logger = LoggerFactory.getLogger(PurchaseService::class.java)

    fun savePurchase(purchaseToSave: Purchase): Purchase {
        logger.info("Saving purchase from company: ${purchaseToSave.store}")
        metricsRegistry.incrementCounter(PURCHASE_COUNTER, TAG_STORE, purchaseToSave.store)
        return repository.save<Purchase>(purchaseToSave)
    }
}