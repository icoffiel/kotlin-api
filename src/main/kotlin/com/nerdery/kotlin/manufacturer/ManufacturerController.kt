package com.nerdery.kotlin.manufacturer

import com.nerdery.kotlin.routes.Routes
import org.springframework.web.bind.annotation.*

/**
 * Controller for Manufacturers
 */
@RestController
@RequestMapping(Routes.MANUFACTURERS_ROOT)
class ManufacturerController (val manufacturerService: ManufacturerService) {

    @GetMapping
    fun index(): List<ManufacturerDto> = manufacturerService.findAll()

    @GetMapping("/{id}")
    fun findOne(@PathVariable("id") id: Long): ManufacturerDto = manufacturerService.findOne(id)

    @PostMapping
    fun create(@RequestBody manufacturerDto: ManufacturerDto): ManufacturerDto = manufacturerService.save(manufacturerDto)

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody manufacturerDto: ManufacturerDto): ManufacturerDto = manufacturerService.update(id, manufacturerDto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long) = manufacturerService.delete(id)
}