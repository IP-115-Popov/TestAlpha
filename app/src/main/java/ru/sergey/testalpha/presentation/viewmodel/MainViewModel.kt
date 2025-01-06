package ru.sergey.testalpha.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.sergey.data.repository.BinRepository
import ru.sergey.data.repository.HistoryRepository
import ru.sergey.testalpha.models.SearchRecord
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val binRepository: BinRepository,
    val historyRepository: HistoryRepository
) : ViewModel() {
    private val _state = MutableStateFlow(MainUiState())
    val state: StateFlow<MainUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            historyRepository.getAll().onEach {history->
                _state.update {
                    it.copy(history = history.map { SearchRecord.fromSearchRecordEntity(it) })
                }
            }.launchIn(viewModelScope)
        }
    }

    fun setBinNumber(value: String) {
        _state.update {
            it.copy(binNumber = value.toLongOrNull() ?: 0L)
        }
    }

    fun fetchBinInfo() {
        _state.update {
            it.copy(status = Status.Loading)
        }
        viewModelScope.launch(Dispatchers.IO) {
            val updatedBinInfo = binRepository.get(state.value.binNumber)
            saveToHistory()
            withContext(Dispatchers.Main){
                _state.update {
                    it.copy(
                        binInfo = updatedBinInfo,
                        status = Status.Idle
                    )
                }
            }
        }
    }

    private suspend fun saveToHistory() {
            historyRepository.save(SearchRecord(binNumber =  state.value.binNumber).toSearchRecordEntity())
    }
}