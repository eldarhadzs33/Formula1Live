import android.text.method.TextKeyListener.clear
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myf1.viewmodel.TelemetryViewModel
import com.patrykandpatrick.vico.core.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.core.cartesian.data.lineSeries
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.VicoScrollState
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberBottom
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStart
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.compose.cartesian.rememberVicoScrollState
import com.patrykandpatrick.vico.core.cartesian.axis.Axis
import com.patrykandpatrick.vico.core.cartesian.axis.HorizontalAxis
import com.patrykandpatrick.vico.core.cartesian.axis.VerticalAxis
import com.patrykandpatrick.vico.core.cartesian.data.CartesianLayerRangeProvider

@Composable
fun TelemetryChartScreen(viewModel: TelemetryViewModel = viewModel()) {


    val telemetry by viewModel.telemetryData.collectAsState()
    val rpmValues = remember(telemetry) { telemetry.map { it.rpm.toFloat() }.ifEmpty { listOf(0f).takeLast(200) } }
    val throttleValues = remember(telemetry) { telemetry.map { it.throttle }.ifEmpty { listOf(0f) }.takeLast(100) }
    val brakeValues = remember(telemetry) { telemetry.map { it.brake.toFloat() }.ifEmpty { listOf(0f) }.takeLast(100) }





    val modelProducer = remember { CartesianChartModelProducer() }

    LaunchedEffect(telemetry) {
        modelProducer.runTransaction {
            lineSeries {

                series(throttleValues)
                series(brakeValues)
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Telemetry Session Chart",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        CartesianChartHost(
            chart = rememberCartesianChart(
                rememberLineCartesianLayer(),
                startAxis = VerticalAxis.rememberStart(),
                bottomAxis = HorizontalAxis.rememberBottom(),

            ),
            modelProducer = modelProducer,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            scrollState = rememberVicoScrollState(scrollEnabled = false)
        )
    }
}