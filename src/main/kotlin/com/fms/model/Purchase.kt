package com.fms.model

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity
data class Purchase(
    @field:Id
    @field:GeneratedValue
    val id: String? = null,
    val store: String,
)
