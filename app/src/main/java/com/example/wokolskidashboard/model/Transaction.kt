package com.example.wokolskidashboard.model

enum class TransactionType {
    INCOME, EXPENSE
}

data class Transaction(val name: String, var price: Int, val type: TransactionType)