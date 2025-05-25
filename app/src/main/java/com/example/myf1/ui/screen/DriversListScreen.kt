package com.example.myf1.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myf1.data.model.Driver
import com.example.myf1.viewmodel.DriversViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.items
import com.example.myf1.ui.component.DriverCard


@Composable
fun DriversListScreen(viewModel: DriversViewModel = viewModel(),navController: NavController) {
    val drivers by viewModel.drivers.collectAsState()
    val loading by viewModel.loading.collectAsState()

    if (loading) {
        CircularProgressIndicator()
    } else {
        LazyColumn {
            items(items = drivers, key = { it.driver_number }) { driver: Driver ->
                DriverCard(driver)
            }
        }
    }
}

