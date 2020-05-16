package com.powerbank.saifusolution

data class Transaction(val id: Int, val merchantName: String, val merchantCategory: String, val amt: Double, val dateString: String, val transactionType: TransactionType)

enum class TransactionType{
    TRANSPORT,
    CLOTHES,
    GROCERY,
    FOOD_AND_BEVERAGE,
    BILLS,
    TRAVEL
}