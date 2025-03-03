package com.ohmz.reminder.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ohmz.reminder.data.repository.ReminderRepository
import com.ohmz.reminder.domain.model.ReminderList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ReminderViewModel @ViewModelInject constructor(
    private val repository: ReminderRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(ReminderUiState())
    val uiState: StateFlow<ReminderUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            repository.getLists().collect { lists ->
                _uiState.update { it.copy(myLists = lists) }
            }
        }
    }
}

data class ReminderUiState(
    val myLists: List<ReminderList> = emptyList()
)