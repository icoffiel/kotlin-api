package com.nerdery.kotlin.manufacturer

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

/**
 * Service for interacting with [Manufacturer] objects. Delegates to [manufacturerRepository] for DB Interactions.
 *
 * @param manufacturerRepository The [ManufacturerRepository] for performing database interactions.
 */
@Service
class ManufacturerService(val manufacturerRepository: ManufacturerRepository) {

    val log = LoggerFactory.getLogger(ManufacturerService::class.java)

    /**
     * Find all [Manufacturer] objects.
     *
     * @return A list of manufacturers.
     */
    fun findAll(): MutableIterable<Manufacturer> {
        log.debug("Received request to find all manufacturers.")
        return manufacturerRepository.findAll()
    }

    /**
     * Find a particular [Manufacturer] using the [id].
     *
     * @param id The Id of the Manufacturer that you want to look up.
     * @return The found [Manufacturer] or null if none is found.
     */
    fun findOne(id: Long): Manufacturer? {
        log.debug("Received request to find manufacturer using id: [{}]", id)
        return manufacturerRepository.findOne(id)
    }

    /**
     * Converts the [manufacturerDto] to a [Manufacturer] and saves it to the database.
     *
     * @param manufacturerDto The [ManufacturerDto] to save.
     * @return An updated [ManufacturerDto].
     */
    fun save(manufacturerDto: ManufacturerDto): ManufacturerDto {
        log.debug("Received request to save manufacturer: [{}]", manufacturerDto)

        val manufacturer = manufacturerDto.ToManufacturer()
        manufacturerRepository.save(manufacturer)
        return manufacturer.toManufacturerDto()
    }

    /**
     * Converts the [manufacturerDto] to a [Manufacturer] and updates it to the database.
     * Uses [id] to set the id on the [Manufacturer] to ensure the correct object is updated.
     *
     * @param id The ID of the object to update.
     * @param manufacturerDto The [ManufacturerDto] to use to update the database.
     * @return An updated [ManufacturerDto].
     */
    fun update(id: Long, manufacturerDto: ManufacturerDto): ManufacturerDto {
        log.debug("Received request to update manufacturer: [{}], with id: [{}]", id)

        val manufacturer = manufacturerDto.ToManufacturer(newId = id)
        manufacturerRepository.save(manufacturer)
        return manufacturer.toManufacturerDto()
    }

    /**
     * Deletes a [Manufacturer] with the id that matches the [id].
     */
    fun delete(id: Long) {
        log.debug("Received request to delete manufacturer: [{}]")
        manufacturerRepository.delete(id)
    }
}

