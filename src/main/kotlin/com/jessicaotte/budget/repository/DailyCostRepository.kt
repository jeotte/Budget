package com.jessicaotte.budget.repository

import com.jessicaotte.budget.model.DailyCost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DailyCostRepository : JpaRepository<DailyCost, Long>