package com.example.qa_banking_app.viewModels

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.qa_banking_app.api_repo.AccountsAPI
import com.example.qa_banking_app.models.Account
import kotlinx.coroutines.launch

class AccountsViewModel(appContext: Application) : AndroidViewModel(appContext) {
    private val accountsAPI = AccountsAPI()
    val accountsList = mutableStateListOf<Account>()
    var selectedAccount = mutableStateOf(Account("", "", "", 0.0))
    var editedList = mutableStateOf(accountsList.toTypedArray().toList())

    init {
        getAccounts()
    }

    fun getAccounts() = viewModelScope.launch {
        accountsList.clear()
        accountsList.addAll(accountsAPI.getAccounts())
        editedList.value = accountsList
    }

    fun getAccount(accountID: String): List<Account> {
        val account = accountsList.filter { it.accountNo == accountID }
        account.let {
            return account
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun filterAccounts(AccountType: String) {
        if (AccountType == "All") {
            editedList.value = accountsList
            return
        }
        editedList.value = accountsList.filter { it.acctType == AccountType }
    }

    fun addAccount(account: Account) = viewModelScope.launch {
        val newAccount = accountsAPI.addAccount(account)
        newAccount?.let {
            accountsList.add(account)
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun editAccount(accountID: String, account: Account) = viewModelScope.launch {
        val editedAccount = accountsAPI.updateAccount(accountID, account)
        editedAccount?.let {
            accountsList.removeIf { it.accountNo == accountID }
            accountsList.add(editedAccount)
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun deleteAccount(accountID: String) = viewModelScope.launch {
        val deleteResponse = accountsAPI.deleteAccount(accountID)
        deleteResponse.let {
            accountsList.removeIf { it.accountNo === accountID }
        }
        println(">>> Delete Response: $deleteResponse")
    }

    fun selectAccount(account: Account) {
        selectedAccount.value = account
    }

    fun getEditedList() = editedList.value


}