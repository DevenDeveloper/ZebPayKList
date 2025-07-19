package com.example.zebpayassignment.ui.klist.compinent

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object KListRenderer {
    @Composable
    fun Render(content: List<KListItem>, padding: Dp = 16.dp) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(content) { item ->
                when (item) {
                    is KListItem.Header -> Text(
                        text = item.text,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    is KListItem.ComposableItem -> item.content()

                    is KListItem.SubHeader -> Text(
                        text = item.text,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    is KListItem.Divider -> HorizontalDivider(
                        color = Color.Gray,
                        thickness = item.height.dp
                    )
                }
            }
        }
    }
}