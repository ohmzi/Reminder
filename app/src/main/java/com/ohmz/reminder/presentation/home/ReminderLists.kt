package com.ohmz.reminder.presentation.home


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.ohmz.reminder.presentation.components.AddListButton
import com.ohmz.reminder.presentation.components.NewReminderButton
import com.ohmz.reminder.presentation.components.ReminderListItem
import com.ohmz.reminder.presentation.components.SectionHeader
import com.ohmz.reminder.presentation.home.ReminderLists
import com.ohmz.reminder.presentation.home.ReminderUiState
import com.ohmz.reminder.presentation.home.ReminderViewModel

@Composable
fun ReminderLists(
    state: ReminderUiState,
    modifier: Modifier = Modifier,
    onAddList: () -> Unit
) {
    LazyColumn(modifier) {
        item { SectionHeader("My Lists") }

        items(state.myLists) { list ->
            ReminderListItem(
                title = list.name,
                count = list.count,
                icon = Icons.Default.List
            )
        }

        item { AddListButton(onAddList) }

        item { SectionHeader("Other") }

        item {
            ReminderListItem(
                title = "Today",
                subtitle = "Scheduled",
                icon = Icons.Default.Today
            )
        }

        item {
            ReminderListItem(
                title = "All",
                subtitle = "Flagged",
                icon = Icons.Default.AllInbox
            )
        }

        item {
            ReminderListItem(
                title = "Completed",
                icon = Icons.Default.CheckCircle
            )
        }
    }
}