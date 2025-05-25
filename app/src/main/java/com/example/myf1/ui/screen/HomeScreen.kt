package com.example.myf1.ui.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

@Composable
fun HomeScreen(navController: NavController) {
    var response by remember { mutableStateOf("Loading...") }

    LaunchedEffect(Unit) {
        try {
            val url = URL("https://api.openf1.org/v1/drivers?session_key=latest&meeting_key=latest")
            withContext(Dispatchers.IO) {
                val connection = url.openConnection() as? HttpURLConnection
                val result = connection?.inputStream?.bufferedReader()?.use { it.readText() }
                connection?.disconnect()
                withContext(Dispatchers.Main) {
                    response = result ?: "No response"
                }
            }
        } catch (e: Exception) {
            response = "Error: ${e.message}"
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(all = 4.dp)
    ) {
        Button(onClick = {navController.navigate("/drivers")}) {
            Text(text = "Drivers")
        }
    }
}
