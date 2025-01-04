package ru.sergey.testalpha.presentation.viewmodel

sealed interface Status {
    data object Idle : Status
    data object Loading : Status
    data class Error(val throwable: Throwable) : Status
}