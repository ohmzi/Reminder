package com.ohmz.reminder.presentation.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ohmz.reminder.presentation.components.NewReminderButton
import com.ohmz.reminder.presentation.home.ReminderLists
import com.ohmz.reminder.presentation.home.ReminderViewModel

@Composable
fun HomeScreen(
    viewModel: ReminderViewModel = hiltViewModel(), // Use hiltViewModel() for Hilt
    onNewReminder: () -> Unit,
    onAddList: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        floatingActionButton = {
            NewReminderButton(onClick = onNewReminder)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            ReminderLists(
                state = state,
                modifier = Modifier.weight(1f),
                onAddList = onAddList
            )
        }
    }
}