import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ohmz.reminder.data.repository.ReminderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel // Use @HiltViewModel instead of @ViewModelInject
class AddListViewModel @Inject constructor(
    private val repository: ReminderRepository
) : ViewModel() {

    // Define the state properly
    private val _uiState = MutableStateFlow(AddListUiState())
    val uiState: StateFlow<AddListUiState> = _uiState

    fun onListNameChange(name: String) {
        _uiState.value = _uiState.value.copy(listName = name)
    }

    fun saveList() {
        viewModelScope.launch {
            repository.createList(_uiState.value.listName).collect {
                // Handle save completion
            }
        }
    }
}

// Define the UI state data class
data class AddListUiState(
    val listName: String = ""
)