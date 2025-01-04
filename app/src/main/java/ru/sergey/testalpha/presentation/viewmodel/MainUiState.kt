package ru.sergey.testalpha.presentation.viewmodel

import ru.sergey.data.models.BinInfo

data class MainUiState(
    val binNumber: Int = 0,
    val binInfo: BinInfo? = null,
    val status: Status = Status.Idle
) {
    val isRefreshing: Boolean
        get() = status == Status.Loading

    val isRefreshError: Boolean
        get() = status is Status.Error
}