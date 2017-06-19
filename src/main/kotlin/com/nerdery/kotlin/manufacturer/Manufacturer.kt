package com.nerdery.kotlin.manufacturer

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Manufacturer(
    var name: String,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?
)

fun Manufacturer.toManufacturerDto(): ManufacturerDto = ManufacturerDto(id = id, name = name)