package com.example.myf1.ui.component

import android.graphics.Color.red
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.myf1.data.model.Driver

@Composable
fun DriverCard(driver: Driver) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(driver.headshot_url),
                contentDescription = driver.full_name,
                modifier = Modifier.size(120.dp)
                    .padding(8.dp),
                
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = driver.full_name,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = driver.country_code ?: "Nepoznata zemlja",
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Tim: ${driver.team_name}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
