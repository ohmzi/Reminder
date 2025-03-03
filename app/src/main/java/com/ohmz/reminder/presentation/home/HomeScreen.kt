package com.ohmz.reminder.presentation.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ohmz.reminder.presentation.components.AddListButton
import com.ohmz.reminder.presentation.components.NewReminderButton
import com.ohmz.reminder.presentation.components.ReminderListItem
import com.ohmz.reminder.presentation.components.SectionHeader
import com.ohmz.reminder.presentation.home.ReminderLists
import com.ohmz.reminder.presentation.home.ReminderUiState
import com.ohmz.reminder.presentation.home.ReminderViewModel

@Composable
fun HomeScreen(
    viewModel: ReminderViewModel = viewModel(),
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
