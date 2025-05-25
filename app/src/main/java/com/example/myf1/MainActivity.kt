package com.example.myf1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.myf1.navigation.NavigatonHost
import com.example.myf1.ui.theme.MyF1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyF1Theme {
                NavigatonHost()
            }
        }
    }
}

