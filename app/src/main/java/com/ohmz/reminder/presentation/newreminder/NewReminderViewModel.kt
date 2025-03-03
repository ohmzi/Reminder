package com.ohmz.reminder.presentation.newreminder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ohmz.reminder.data.repository.ReminderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewReminderViewModel @ViewModelInject constructor(
    private val repository: ReminderRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(NewReminderUiState())
    val uiState: StateFlow<NewReminderUiState> = _uiState.asStateFlow()

    fun onTitleChange(title: String) {
        _uiState.update { it.copy(title = title) }
    }

    fun saveReminder() {
        viewModelScope.launch {
            repository.saveReminder(state.title).collect {
                // Handle save completion
            }
        }
    }
}

data class NewReminderUiState(
    val title: String = ""
)