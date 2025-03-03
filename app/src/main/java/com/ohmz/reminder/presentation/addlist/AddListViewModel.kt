package com.ohmz.reminder.presentation.addlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ohmz.reminder.data.repository.ReminderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddListViewModel @ViewModelInject constructor(
    private val repository: ReminderRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(AddListUiState())
    val uiState: StateFlow<AddListUiState> = _uiState.asStateFlow()

    fun onListNameChange(name: String) {
        _uiState.update { it.copy(listName = name) }
    }

    fun saveList() {
        viewModelScope.launch {
            repository.createList(state.listName).collect {
                // Handle save completion
            }
        }
    }
}

data class AddListUiState(
    val listName: String = ""
)