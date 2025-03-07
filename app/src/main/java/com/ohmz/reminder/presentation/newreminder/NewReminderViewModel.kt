import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ohmz.reminder.data.repository.ReminderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewReminderViewModel @Inject constructor(
    private val repository: ReminderRepository
) : ViewModel() {

    // Define the state properly
    private val _uiState = MutableStateFlow(NewReminderUiState())
    val uiState: StateFlow<NewReminderUiState> = _uiState

    fun onTitleChange(title: String) {
        _uiState.value = _uiState.value.copy(title = title)
    }

    fun saveReminder() {
        viewModelScope.launch {
            repository.saveReminder(_uiState.value.title).collect {
                // Handle save completion
            }
        }
    }
}

// Define the UI state data class
data class NewReminderUiState(
    val title: String = ""
)