package ru.sergey.testalpha.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import ru.sergey.testalpha.presentation.viewmodel.MainViewModel

@Composable
fun HistoryScreen(mainViewModel: MainViewModel) {

    val state = mainViewModel.state.collectAsState()


}