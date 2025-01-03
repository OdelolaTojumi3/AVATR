package com.example.avatr

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.avatr.ui.screens.SideMenuScreen
import com.example.avatr.ui.theme.AvatrTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {

            val darkTheme = mutableStateOf(isSystemInDarkTheme())

            AvatrTheme{
//                val images1 = listOf(
//                    R.drawable._1,
//                    R.drawable._2
//                )
//
//                val images2 = listOf(
//                    R.drawable._3,
//                    R.drawable._4,
//                    R.drawable._5
//                )
                Surface(modifier = Modifier.fillMaxSize()) {
                    SideMenuScreen(isDarkTheme = darkTheme)
                }
            }
        }
    }
}