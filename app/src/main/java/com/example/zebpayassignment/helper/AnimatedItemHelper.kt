package com.example.zebpayassignment.helper

import androidx.compose.animation.*
import androidx.compose.runtime.*

@Composable
fun AnimatedKListItem(content: @Composable () -> Unit) {
    val visible = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible.value = true
    }

    AnimatedVisibility(
        visible = visible.value,
        enter = fadeIn() + slideInVertically(initialOffsetY = { it / 2 }),
        exit = fadeOut()
    ) {
        content()
    }
}