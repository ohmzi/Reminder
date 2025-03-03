package com.ohmz.reminder.presentation.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun AddListButton(onClick: () -> Unit) {
    TextButton(onClick = onClick) {
        Text("Add List")
    }
}