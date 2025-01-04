package ru.sergey.testalpha.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.sergey.data.repository.BinRepository

class MainViewModel(val binRepository: BinRepository) : ViewModel() {
    private val _state = MutableStateFlow(MainUiState())
    val state: StateFlow<MainUiState> = _state.asStateFlow()


    fun setBinNumber(value: String) {
        _state.update {
            it.copy(binNumber = value.toIntOrNull() ?: 0)
        }
    }

    fun fetchBinInfo() {
        _state.update {
            it.copy(status = Status.Loading)
        }
        viewModelScope.launch {
            val updatedBinInfo = binRepository.get()
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
}