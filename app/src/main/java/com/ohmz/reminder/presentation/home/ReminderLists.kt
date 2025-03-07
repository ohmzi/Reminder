package com.ohmz.reminder.presentation.home


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ohmz.reminder.presentation.components.AddListButton
import com.ohmz.reminder.presentation.components.ReminderListItem
import com.ohmz.reminder.presentation.components.SectionHeader

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
                icon = Icons.AutoMirrored.Filled.List
            )
        }

        item { AddListButton(onAddList) }

        item { SectionHeader("Other") }

        item {
            ReminderListItem(
                title = "Today",
                subtitle = "Scheduled",
                icon = Icons.Default.CheckCircle
            )
        }

        item {
            ReminderListItem(
                title = "All",
                subtitle = "Flagged",
                icon = Icons.Default.Email
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