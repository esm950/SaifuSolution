package com.powerbank.saifusolution.utils

fun Double.toPriceString(): String {
    return "- $${this.toPriceFormat()}"
}

fun Double.toPriceFormat(): String =
    this.toString().toNumberFormat()


fun String.toNumberFormat(): String =
    String.format("%.2f", this.toDoubleOrNull())