package com.example.zebpayassignment.ui.klist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.zebpayassignment.models.Coin
import com.example.zebpayassignment.ui.klist.compinent.CoinCardItem
import com.example.zebpayassignment.ui.klist.compinent.KList
import com.example.zebpayassignment.ui.klist.compinent.KListItem
import com.example.zebpayassignment.ui.theme.ZebPayAssignmentTheme

class KListDemo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZebPayAssignmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CoinListScreen(innerPadding = innerPadding)
                }
            }
        }
    }
}

// Composable to render the K list
@Composable
private fun CoinListScreen(innerPadding: PaddingValues) {
    val sampleCoins = listOf(
        Coin("Bitcoin", "$29,000", 1.25f),
        Coin("Ethereum", "$1,800", -0.85f),
        Coin("Solana", "$24.50", 3.70f),
        Coin("Cardano", "$0.29", 2.10f),
        Coin("Ripple", "$0.72", -1.45f),
        Coin("Polkadot", "$5.20", 0.65f)
    )
    Column(modifier = Modifier.padding(innerPadding)) {
        KListDisplay(coinList = sampleCoins)
    }
}

@Composable
private fun KListDisplay(coinList: List<Coin>) {
    val context = LocalContext.current
    KList()
        .padding(16.dp)
        .header("Top Gainers")
        .subHeader("Today's Information")
        .divider(1)
        .items(coinList) { coin ->
            KListItem.CoinCardItem(coin) {
                this.modifier(Modifier.padding(horizontal = 8.dp))
                this.animated(true)
                this.onClick {
                    Toast.makeText(context, "${coin.name} clicked", Toast.LENGTH_SHORT).show()
                }
            }
        }
        .Render()
}