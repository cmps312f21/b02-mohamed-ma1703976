package com.example.qa_banking_app.views

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.qa_banking_app.common.getCurrentRoute
import com.example.qa_banking_app.models.Account
import com.example.qa_banking_app.viewModels.AccountsViewModel

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AccountForm(navHostController: NavHostController) {
    val accountStore =
        viewModel<AccountsViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    val selectedAccount = accountStore.selectedAccount.value
    var accountName by remember {
        mutableStateOf(selectedAccount.name)
    }
    var accountNo by remember {
        mutableStateOf(selectedAccount.accountNo)
    }
    var accountBal by remember {
        mutableStateOf(selectedAccount.balance)
    }
    var accountType by remember {
        mutableStateOf(selectedAccount.acctType)
    }
    val accountTypes = listOf("Current", "Savings")

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .background(color = Color.Transparent)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = if (selectedAccount.accountNo.isNotEmpty()) "Edit Account" else "Add Account")
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = accountName ?: "",
                onValueChange = { accountName = it },
                placeholder = {
                    Text(
                        text = "Enter Account Name"
                    )
                })
            OutlinedTextField(
                value = accountNo ?: "",
                onValueChange = { accountNo = it },
                placeholder = {
                    Text(
                        text = "Enter Account Number"
                    )
                })
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier.padding(horizontal = 35.dp)
            ) {
                Dropdown(
                    label = "Select Account Type",
                    options = accountTypes,
                    selectedOption = accountType,
                    onSelectionChange = { accountType = it }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = "$accountBal",
                onValueChange = { accountBal = it.toDouble() },
                placeholder = {
                    Text(
                        text = "Enter Account Balance"
                    )
                })
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                if (selectedAccount.accountNo.isNotEmpty()) {
                    accountStore.editAccount(
                        selectedAccount.accountNo,
                        Account(accountNo, accountName, accountType, accountBal)
                    )
                } else {
                    accountStore.addAccount(
                        Account(
                            accountNo,
                            accountName,
                            accountType,
                            accountBal
                        )
                    )
                }
                navHostController.navigate(Screen.AccountList.route)
            }) {
                Text(text = "Submit")
            }
        }
    }

}
