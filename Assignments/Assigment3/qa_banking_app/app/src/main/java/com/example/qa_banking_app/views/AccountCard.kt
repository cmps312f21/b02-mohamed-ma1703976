package com.example.qa_banking_app.views

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qa_banking_app.models.Account

@Composable
fun AccountCard(
    account: Account,
    deleteAccount: (ID: String) -> Unit,
    editAccount: (account: Account) -> Unit
) {
    Card(
        elevation = 20.dp,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
            ) {
                Text(text = account.name)
                Spacer(modifier = Modifier.height(7.dp))
                Text(text = account.accountNo)
                Spacer(modifier = Modifier.height(7.dp))
                Text(text = account.acctType)
            }
            Box(
                modifier = Modifier
                    .height(90.dp),
                contentAlignment = Alignment.BottomCenter,
            ) {
                Text(text = "${account.balance} QR")
            }
            Column(

            ) {
                IconButton(onClick = { deleteAccount(account.accountNo) }) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete Button")
                }
                IconButton(onClick = { editAccount(account) }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit Button")
                }
            }
        }
    }
}