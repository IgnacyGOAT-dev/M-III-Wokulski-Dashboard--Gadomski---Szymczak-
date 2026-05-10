package com.example.wokolskidashboard.ui.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExpenseForm(onAddExpense: (name: String, amount: Double, isOptional: Boolean) -> Unit) {
    var name by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var isOptional by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Wydatki", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = { Text("Cel wydatku") },
            leadingIcon = { Icon(Icons.Default.Edit, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = amount,
            onValueChange = {
                amount = it
            },
            label = { Text("Kwota") },
            leadingIcon = { Icon(Icons.Default.KeyboardArrowDown, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Wydatek zbyteczny")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = isOptional,
                onCheckedChange = { isOptional = it }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                val parsedAmount = amount.toDoubleOrNull()

                if (name.isNotBlank() && parsedAmount != null && parsedAmount > 0) {
                    onAddExpense(name, parsedAmount, isOptional)

                    name = ""
                    amount = ""
                    isOptional = false
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Zapisz wydatek")
        }
    }
}