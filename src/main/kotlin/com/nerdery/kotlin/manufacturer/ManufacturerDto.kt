package com.nerdery.kotlin.manufacturer

data class ManufacturerDto(val id: Long?, val name: String)

fun ManufacturerDto.ToManufacturer(newId: Long? = id): Manufacturer = Manufacturer(id = newId, name = name)