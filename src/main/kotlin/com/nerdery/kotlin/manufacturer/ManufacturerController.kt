package com.nerdery.kotlin.manufacturer

import org.springframework.web.bind.annotation.*

/**
 * Controller for Manufacturers
 */
@RestController
@RequestMapping("/manufacturers")
class ManufacturerController (val manufacturerService: ManufacturerService) {

    @GetMapping
    fun index() = manufacturerService.findAll()

    @GetMapping("/{id}")
    fun findOne(@PathVariable("id") id: Long): Manufacturer = manufacturerService.findOne(id)

    @PostMapping
    fun create(@RequestBody manufacturerDto: ManufacturerDto): ManufacturerDto = manufacturerService.save(manufacturerDto)

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody manufacturerDto: ManufacturerDto): ManufacturerDto = manufacturerService.update(id, manufacturerDto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) = manufacturerService.delete(id)
}