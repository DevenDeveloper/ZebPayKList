package com.example.zebpayassignment.ui.klist.component


import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class KList {
    private val items = mutableListOf<KListItem>()
    private var padding: Dp = 0.dp

    fun padding(p: Dp) = apply {
        this.padding = p
    }

    fun header(title: String) = apply {
        items.add(KListItem.Header(title))
    }

    fun subHeader(title: String) = apply {
        items.add(KListItem.SubHeader(title))
    }

    fun divider(height: Int) = apply {
        items.add(KListItem.Divider(height))
    }

    fun <T> items(data: List<T>, itemContent: (T) -> KListItem) = apply {
        data.forEach {
            items.add(itemContent(it))
        }
    }

    @Composable
    fun Render() {
        KListRenderer.Render(content = items, padding = padding)
    }
}