package com.example.wokolskidashboard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.model.TransactionType
import com.example.wokolskidashboard.ui.components.ExpenseForm



@Composable
fun MainScreen(modifier: Modifier = Modifier){
    val transactions = remember { mutableStateListOf<Transaction>() }

    val balance = transactions.sumOf {
        if (it.type == TransactionType.EXPENSE) -it.amount else it.amount
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Saldo: $balance",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        ExpenseForm(
            onAddExpense = { name, amount, isOptional ->
                transactions.add(
                    Transaction(
                        name = name,
                        amount = amount,
                        type = TransactionType.EXPENSE,
                        isOptional = isOptional
                    )
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(transactions) { transaction ->
                Text(
                    text = "${transaction.name}: ${
                        if (transaction.type == TransactionType.EXPENSE) "-" else "+"
                    }${transaction.amount}",

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                )
            }
        }
    }
}