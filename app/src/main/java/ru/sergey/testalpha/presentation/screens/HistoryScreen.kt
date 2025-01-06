package ru.sergey.testalpha.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import ru.sergey.testalpha.presentation.viewmodel.MainViewModel

@Composable
fun HistoryScreen(mainViewModel: MainViewModel) {

    val state = mainViewModel.state.collectAsState()

    LazyColumn(
        Modifier.fillMaxSize()
    ){
        items(state.value.history) { item ->
            Text(item.binNumber.toString(), fontSize = 24.sp)
        }
    }
}