package com.fms.service

import io.micrometer.core.instrument.MeterRegistry
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class MetricsRecord {
    @Inject
    lateinit var meterRegistry: MeterRegistry

    fun incrementCounter(counterName: String, counterParam: String) =
        meterRegistry
            .counter(counterName, counterParam)
            .increment(1.0)
}