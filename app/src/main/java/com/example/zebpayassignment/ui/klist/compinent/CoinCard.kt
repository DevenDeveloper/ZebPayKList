package com.example.zebpayassignment.ui.klist.compinent

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zebpayassignment.models.Coin

@Composable
fun CoinCard(coin: Coin, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    val isUp = coin.priceChangePercent >= 0

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .animateContentSize()
            .clickable { onClick() },
        shape = RoundedCornerShape(14.dp)
    ) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = coin.name, fontSize = 18.sp, color = Color.Black)
                Text(text = coin.price, fontSize = 14.sp, color = Color.Gray)
            }
            Icon(
                imageVector = if (isUp) Icons.Default.KeyboardArrowUp else Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = if (isUp) Color.Green else Color.Red
            )
            Text(
                text = "${coin.priceChangePercent}%",
                color = if (isUp) Color.Green else Color.Red,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}