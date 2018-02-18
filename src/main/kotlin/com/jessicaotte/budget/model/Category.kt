package com.jessicaotte.budget.model

enum class Category (val value: String){
    RESTAURANTS("Restaurants"),
    GAS("Gas"),
    GROCERIES("Groceries"),
    MISC("Misc"),
    SEMI_REGULAR_COST("Misc Regular Cost");

    override fun toString() = value
}