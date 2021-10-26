package com.example.qa_banking_app.models

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val accountNo: String,
    val name: String,
    val acctType: String,
    val balance: Double,
)