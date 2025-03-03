package com.ohmz.reminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ohmz.reminder.presentation.homescreen.HomeScreen
import com.ohmz.reminder.presentation.navigation.ReminderNavHost
import com.ohmz.reminder.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                ReminderNavHost()
            }
        }
    }
}