package com.jessicaotte.budget.controller

import com.jessicaotte.budget.model.DailyCost
import com.jessicaotte.budget.repository.DailyCostRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController (private val dailyCostRepository: DailyCostRepository) {

    @RequestMapping("/")
    fun index(model: Model): String {
        model.addAttribute("dailycost", DailyCost())
        model.addAttribute("lastWeekDailyCosts", dailyCostRepository.findAll())
        return "index"
    }
}
