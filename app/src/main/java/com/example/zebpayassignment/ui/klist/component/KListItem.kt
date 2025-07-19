package com.example.zebpayassignment.ui.klist.component

import androidx.compose.runtime.Composable
import com.example.zebpayassignment.models.Coin

sealed class KListItem {
    data class Header(val text: String) : KListItem()
    data class SubHeader(val text: String) : KListItem()

    data class Divider(val height: Int) : KListItem()
    data class ComposableItem(val content: @Composable () -> Unit) : KListItem()

    companion object
}

fun KListItem.Companion.CoinCardItem(coin: Coin, builder: CoinItemBuilder.() -> Unit = {}): KListItem {
    return CoinItemBuilder(coin).apply(builder).build()
}