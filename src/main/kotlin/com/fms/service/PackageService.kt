package com.fms.service

import com.fms.model.Package
import com.fms.repository.PackagesRepository
import jakarta.inject.Singleton
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Singleton
class PackageService(
    private val repository: PackagesRepository,
    private val metricsRecord: MetricsRecord
) {
    private val logger: Logger = LoggerFactory.getLogger(PackageService::class.java)

    fun savePackage(packageToSave: Package): Package {
        logger.info("Saving package from company: ${packageToSave.companyName}")
        metricsRecord.incrementCounter("packages.saved.counter", packageToSave.companyName)
        return repository.save<Package>(packageToSave)
    }

    fun findPackage(id: String): Package {
        logger.info("Getting package with name: $id")
        val savedPackage = repository.findById(id).orElseThrow { Exception("Package not found") }
        metricsRecord.incrementCounter("packages.found.counter", savedPackage.companyName)
        return savedPackage
    }
}