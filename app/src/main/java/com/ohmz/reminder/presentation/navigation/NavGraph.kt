package com.ohmz.reminder.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ohmz.reminder.presentation.addlist.AddListScreen
import com.ohmz.reminder.presentation.homescreen.HomeScreen
import com.ohmz.reminder.presentation.newreminder.NewReminderScreen

@Composable
fun ReminderNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.HomeScreen.route,
        modifier = modifier
    ) {
        composable(Destinations.HomeScreen.route) {
            HomeScreen(
                onNewReminder = { navController.navigate(Destinations.NewReminder.route) },
                onAddList = { navController.navigate(Destinations.AddList.route) }
            )
        }

        composable(Destinations.NewReminder.route) {
            NewReminderScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable(Destinations.AddList.route) {
            AddListScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}