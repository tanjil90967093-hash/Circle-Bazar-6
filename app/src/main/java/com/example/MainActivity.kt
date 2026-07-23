package com.example

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun attachBaseContext(newBase: Context) {
    val configuration = Configuration(newBase.resources.configuration)
    configuration.fontScale = 1.0f
    val context = newBase.createConfigurationContext(configuration)
    super.attachBaseContext(context)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val currentDensity = LocalDensity.current
      CompositionLocalProvider(
          LocalDensity provides Density(currentDensity.density, fontScale = 1f)
      ) {
        MyApplicationTheme {
          CircleBazarApp()
        }
      }
    }
  }
}
