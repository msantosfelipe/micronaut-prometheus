package com.fms.controller

import com.fms.model.Package
import com.fms.repository.PackagesRepository
import com.fms.service.PackageService
import io.micrometer.core.instrument.MeterRegistry
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import jakarta.inject.Inject
import jakarta.validation.constraints.NotBlank

@Validated
@Controller("/packages")
class PackageController(
    private val service: PackageService
) {
    @Inject
    lateinit var meterRegistry: MeterRegistry

    @Post
    fun savePackage(@Body packageToSave: Package) = service.savePackage(packageToSave)

    @Get("/{id}")
    fun getPackage(@NotBlank id: String) = service.findPackage(id)

}
