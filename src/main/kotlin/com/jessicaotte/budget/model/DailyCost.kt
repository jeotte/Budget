package com.jessicaotte.budget.model

import org.hibernate.validator.constraints.NotBlank
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class DailyCost (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        val amount: Double = 0.0,

        @get: NotBlank
        val category: String = ""
)