package ru.sergey.data.models

data class BinInfo(
    val number: NumberInfo,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val country: CountryInfo,
    val bank: BankInfo
)