package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExpenseForm(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp),
        Arrangement.spacedBy(8.dp),
        Alignment.CenterHorizontally
    ) {
        Text(
            text = "Formularz Wydatków",
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        TextField(
            value = "jakis tekst",
            onValueChange = {},
            label = { Text("Enter yoour name:") },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                println("Button Clicked")
            }) {
            Text("Show name")
        }
    }
}