package com.fms.infrastructure

import io.micrometer.core.instrument.MeterRegistry
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class MetricsRegistry {
    @Inject
    lateinit var meterRegistry: MeterRegistry

    fun incrementCounter(counterName: String, tagName: String, counterParam: String) =
        meterRegistry
            .counter(counterName, tagName, counterParam)
            .increment(1.0)

    companion object {
        const val PURCHASE_COUNTER = "purchase"
        const val TAG_STORE = "company"
    }
}