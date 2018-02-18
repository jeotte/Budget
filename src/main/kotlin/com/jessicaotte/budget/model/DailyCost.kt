package com.jessicaotte.budget.model

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class DailyCost (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,

        var amount: Double = 0.0,

        var category: Category = Category.RESTAURANTS,

        var comments: String = "",

        var dateOfPurchase: LocalDate = LocalDate.now()
)