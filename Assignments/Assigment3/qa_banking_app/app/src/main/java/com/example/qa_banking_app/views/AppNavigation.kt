package com.example.qa_banking_app.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(navHostController, startDestination = Screen.AccountList.route) {
        composable(route = Screen.AccountList.route) {
            AccountList(navHostController)
        }
        composable(route = Screen.AccountForm.route) {
            AccountForm(navHostController)
        }
    }
}