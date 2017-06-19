package com.nerdery.kotlin.manufacturer

data class ManufacturerDto(val id: Long?, val name: String)

/**
 * Converts a [ManufacturerDto] to a [Manufacturer]. A [newId] can be passed for the object (used in [ManufacturerService.update] which will replace the current ID.
 *
 * @param newId The new id to use, defaults to the existing ID if not passed in.
 * @return The converted [ManufacturerDto].
 */
fun ManufacturerDto.ToManufacturer(newId: Long? = id): Manufacturer = Manufacturer(id = newId, name = name)