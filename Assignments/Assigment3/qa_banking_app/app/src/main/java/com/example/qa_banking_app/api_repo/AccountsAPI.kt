package com.example.qa_banking_app.api_repo

import com.example.qa_banking_app.models.Account
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*


class AccountsAPI {
    private val URL = "https://employee-bank-app.herokuapp.com/api"
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(json = kotlinx.serialization.json.Json {
                run {
                    isLenient = true
                }
            })
        }
    }

    suspend fun getAccounts(): List<Account> {
        val thisUrl = "$URL/accounts"
        return client.get(thisUrl)
    }

    suspend fun addAccount(account: Account): Account? {
        val thisURL = "$URL/accounts"
        return client.post {
            url(thisURL)
            contentType(ContentType.Application.Json)
            body = account
        }
    }

    suspend fun updateAccount(ID: String, account: Account): Account? {
        val thisURL = "$URL/accounts/$ID"
        return client.put {
            url(thisURL)
            contentType(ContentType.Application.Json)
            body = account
        }
    }

    suspend fun deleteAccount(ID: String): String {
        val thisURL = "$URL/accounts/$ID"
        return client.delete(thisURL)
    }


}