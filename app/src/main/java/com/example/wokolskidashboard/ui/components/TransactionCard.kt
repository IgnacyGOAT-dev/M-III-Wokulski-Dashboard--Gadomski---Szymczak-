package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.model.TransactionType


@Composable
fun TransactionCard(transaction: Transaction) {

    val amountColor = if (transaction.type == TransactionType.EXPENSE) Color.Red else Color.Green
    val backgroundColor = amountColor.copy(alpha = 0.15f)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = transaction.name,
            style = MaterialTheme.typography.bodyLarge
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "${
                    if (transaction.type == TransactionType.EXPENSE) "-" else "+"
                }${"%.2f".format(transaction.amount)}",
                color = amountColor,
                style = MaterialTheme.typography.bodyLarge
            )

            if (transaction.isOptional) {
                Spacer(modifier = Modifier.width(6.dp))

                Box(
                    modifier = Modifier
                        .size(15.dp)
                        .clip(CircleShape)
                        .background(Color.Yellow)
                )
            }
        }
    }
}