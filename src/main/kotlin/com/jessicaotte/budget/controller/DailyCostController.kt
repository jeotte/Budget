package com.jessicaotte.budget.controller

import com.jessicaotte.budget.model.DailyCost
import com.jessicaotte.budget.repository.DailyCostRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api")
class DailyCostController (private val dailyCostRepository: DailyCostRepository) {

    @GetMapping("/dailycosts")
    fun getAllDailyCosts(model: Model): String {
        model.addAttribute("dailycosts", dailyCostRepository.findAll())
        return "index"
    }

    @PostMapping("/dailycosts")
    fun createNewDailyCost(dailycost: DailyCost, result: BindingResult): String {
        dailyCostRepository.save(dailycost)
        return "redirect:/"
    }
}
