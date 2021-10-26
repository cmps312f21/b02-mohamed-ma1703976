package com.example.qa_banking_app.views

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.qa_banking_app.viewModels.AccountsViewModel

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AccountList(navHostController: NavHostController) {
    val accountStore =
        viewModel<AccountsViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)

    var selectedFilter by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        Dropdown(
            label = "Filter By",
            options = listOf("Saving", "Current", "All"),
            selectedOption = selectedFilter,
            onSelectionChange = {
                selectedFilter = it
                accountStore.filterAccounts(it)
            }
        )
        LazyColumn {
            items(accountStore.getEditedList()) { account ->
                AccountCard(
                    account,
                    deleteAccount = { accountStore.deleteAccount(it) },
                    editAccount = {
                        accountStore.selectAccount(it)
                        navHostController.navigate("Account_Form")
                    })
            }
        }
    }
}