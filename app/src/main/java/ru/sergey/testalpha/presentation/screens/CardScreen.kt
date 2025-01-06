package ru.sergey.testalpha.presentation.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sergey.testalpha.presentation.viewmodel.MainViewModel

@Composable
fun CardScreen(mainViewModel: MainViewModel, context: Context) {
    val state = mainViewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Enter BIN number", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        BasicTextField(
            value = state.value.binNumber.toString(),
            onValueChange = { mainViewModel.setBinNumber(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { mainViewModel.fetchBinInfo() },
            modifier = Modifier.padding(top = 16.dp),
            enabled = state.value.binNumber.toString().length >= 6
        ) {
            Text("Get Info")
        }

        Spacer(modifier = Modifier.height(32.dp))

        if (state.value.isRefreshing) {
            CircularProgressIndicator()
        } else {
            Column(horizontalAlignment = Alignment.Start) {
                state.value.binInfo?.apply {
                    Text("Country: ${country.name}", fontSize = 18.sp)
                    Text("latitude: ${country.latitude}", fontSize = 18.sp)
                    Text("longitude: ${country.longitude}", fontSize = 18.sp)
                    Text("Card Type: ${scheme}", fontSize = 18.sp)
                    Text("Card Brand: ${brand}", fontSize = 18.sp)

                    Spacer(modifier = Modifier.height(16.dp))

                    Text("Bank Info:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text("Name: ${bank.name}", fontSize = 18.sp)
                    Text("URL: ${bank.url}", fontSize = 18.sp)
                    Text("Phone: ${bank.phone}", fontSize = 18.sp)
                    Text("City: ${bank.city}", fontSize = 18.sp)
                }
            }
        }
    }
}



