package com.example.qa_banking_app

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.qa_banking_app.common.getCurrentRoute
import com.example.qa_banking_app.models.Account
import com.example.qa_banking_app.ui.theme.QABankingAppTheme
import com.example.qa_banking_app.viewModels.AccountsViewModel
import com.example.qa_banking_app.views.AccountList
import com.example.qa_banking_app.views.AppNavigation
import com.example.qa_banking_app.views.Screen

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QABankingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun Greeting() {
    val navHostController = rememberNavController()
    val accountStore =
        viewModel<AccountsViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
            ) {
                if (getCurrentRoute(navHostController) === "Account_Form") {
                    IconButton(onClick = { navHostController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back Arrow"
                        )
                    }
                }
                Text(
                    text = "Accounts List",
                    fontWeight = FontWeight.Bold
                )
            }
        },
        floatingActionButton = {
            if (getCurrentRoute(navHostController) !== "Account_Form") {
                IconButton(
                    onClick = {
                        accountStore.selectAccount(Account("", "", "", 0.0))
                        navHostController.navigate(Screen.AccountForm.route)
                    },
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(
                            Color.Cyan
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Floating Button",
                    )
                }
            }
        }
    ) {
        AppNavigation(navHostController)
    }
}
