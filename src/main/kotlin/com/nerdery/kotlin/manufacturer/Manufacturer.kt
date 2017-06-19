package com.nerdery.kotlin.manufacturer

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Domain Entity for a Manufacturer.
 *
 * @param id The ID of the manufacturer.
 * @param name The name of the manufacturer.
 */
@Entity
class Manufacturer(
    var name: String,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?
)

/**
 * Converts a [Manufacturer] to a [ManufacturerDto].
 */
fun Manufacturer.toManufacturerDto(): ManufacturerDto = ManufacturerDto(id = id, name = name)