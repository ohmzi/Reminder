package com.ohmz.reminder.presentation.navigation

sealed class Destinations(val route: String) {
    object HomeScreen : Destinations("home")
    object NewReminder : Destinations("new_reminder")
    object AddList : Destinations("add_list")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}