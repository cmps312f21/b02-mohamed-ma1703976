package com.example.qa_banking_app.views

sealed class Screen(val route: String, val title: String) {
    object AccountForm : Screen("Account_Form", "Account Editor")
    object AccountList : Screen("Account_List", "Accounts List")
}