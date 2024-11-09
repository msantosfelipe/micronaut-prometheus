package com.fms.controller

import com.fms.model.Purchase
import com.fms.service.PurchaseService
import io.micrometer.core.instrument.MeterRegistry
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import jakarta.inject.Inject

@Validated
@Controller("/purchases")
class PackageController(
    private val service: PurchaseService
) {
    @Inject
    lateinit var meterRegistry: MeterRegistry

    @Post
    fun savePurchase(@Body purchaseToSave: Purchase) = service.savePurchase(purchaseToSave)
}
