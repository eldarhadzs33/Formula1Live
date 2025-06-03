import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myf1.viewmodel.TelemetryViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.myf1.data.model.CarData

@Composable
fun TelemetryScreen(viewModel: TelemetryViewModel = viewModel()) {
    val telemetry by viewModel.telemetryData.collectAsState()

    // Fetch telemetry ONCE (historical snapshot)
    LaunchedEffect(Unit) {
        viewModel.fetchTelemetry(driverNumber = 1) // <-- Static historical fetch
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(telemetry) { data ->
            TelemetryRow(data)
            Divider()
        }
    }
}

@Composable
fun TelemetryRow(carData: CarData) {
    // Animacija za smooth progress
    val throttleAnim by animateFloatAsState(targetValue = carData.throttle / 100f)
    val brakeAnim by animateFloatAsState(targetValue = carData.brake / 100f)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "RPM: ${carData.rpm}")

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Throttle: ${"%.2f".format(carData.throttle)}%")
        LinearProgressIndicator(
            progress = throttleAnim,
            color = Color.Green,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Brake: ${carData.brake}%")
        LinearProgressIndicator(
            progress = brakeAnim,
            color = Color.Red,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )
    }
}
