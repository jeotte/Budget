package com.jessicaotte.budget.controller

import com.jessicaotte.budget.model.DailyCost
import com.jessicaotte.budget.repository.DailyCostRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class DailyCostController (private val dailyCostRepository: DailyCostRepository) {

    @GetMapping("/dailycosts")
    fun getAllDailyCosts(): List<DailyCost> = dailyCostRepository.findAll()

    @PostMapping("/dailycosts")
    fun createNewDailyCost(@Valid @RequestBody dailycost: DailyCost): DailyCost = dailyCostRepository.save(dailycost)

    @GetMapping("/dailycosts/{id}")
    fun getDailyCostById(@PathVariable(value = "id") dailyCostId: Long): ResponseEntity<DailyCost> {
        val cost: DailyCost? = dailyCostRepository.findOne(dailyCostId)
        return if (cost != null) ResponseEntity.ok(cost) else ResponseEntity.notFound().build()
    }

    @PutMapping("/dailycosts/{id}")
    fun updateDailyCostById(@PathVariable(value = "id") dailyCostId: Long,
                            @Valid @RequestBody newDailyCost: DailyCost): ResponseEntity<DailyCost> {
        val existingDailyCost: DailyCost? = dailyCostRepository.findOne(dailyCostId)
        if (existingDailyCost != null) {
            val updatedDailyCost: DailyCost? = existingDailyCost.copy(amount = newDailyCost.amount, category = newDailyCost.category)
            return ResponseEntity.ok().body(dailyCostRepository.save(updatedDailyCost))
        } else {
            return ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/dailycosts/{id}")
    fun deleteDailyCostById(@PathVariable(value = "id") dailyCostId: Long): ResponseEntity<Void> {
        val existingDailyCost : DailyCost? = dailyCostRepository.findOne(dailyCostId)
        if (existingDailyCost != null) {
            dailyCostRepository.delete(existingDailyCost)
            return ResponseEntity<Void>(HttpStatus.OK)
        } else {
            return ResponseEntity.notFound().build()
        }
    }
}