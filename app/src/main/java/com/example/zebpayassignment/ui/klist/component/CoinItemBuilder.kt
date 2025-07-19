package com.example.zebpayassignment.ui.klist.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.zebpayassignment.helper.AnimatedKListItem
import com.example.zebpayassignment.models.Coin

class CoinItemBuilder(private val coin: Coin) {
    private var modifier: Modifier = Modifier
    private var onClick: () -> Unit = {}
    private var animate: Boolean = false

    fun modifier(modifier: Modifier): CoinItemBuilder {
        this.modifier = modifier
        return this
    }

    fun animated(animate: Boolean = true): CoinItemBuilder {
        this.animate = animate
        return this
    }

    fun onClick(listener: () -> Unit): CoinItemBuilder {
        this.onClick = listener
        return this
    }

    fun build(): KListItem {
        return KListItem.ComposableItem {
            val content = @Composable {
                CoinCard(coin = coin, modifier = modifier, onClick = onClick)
            }
            if (animate) {
                AnimatedKListItem { content() }
            } else {
                content()
            }
        }
    }
}