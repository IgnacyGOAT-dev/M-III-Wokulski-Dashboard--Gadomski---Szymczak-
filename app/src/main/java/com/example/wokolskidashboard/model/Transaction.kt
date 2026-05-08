package com.example.wokolskidashboard.model

enum class TransactionType {
    INCOME, EXPENSE
}

data class Transaction(
    val name: String,
    val amount: Double,
    val type: TransactionType,
    val isOptional: Boolean = false
)