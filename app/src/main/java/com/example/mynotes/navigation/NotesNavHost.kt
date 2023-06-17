package com.example.mynotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mynotes.screens.AddScreen
import com.example.mynotes.screens.MainScreen
import com.example.mynotes.screens.NoteScreen
import com.example.mynotes.screens.StartScreen

sealed class NavRoute(val route: String){
    object Start: NavRoute ("start_screen")
    object Main: NavRoute ("main_screen")
    object Add: NavRoute ("add_screen")
    object Note: NavRoute ("note_screen")
}

@Composable
fun NotesNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route) {
            StartScreen(navController = navController)
        }
        composable(NavRoute.Main.route) {
            MainScreen(navController = navController)
        }
        composable(NavRoute.Add.route) {
            AddScreen(navController = navController)
        }
        composable(NavRoute.Note.route) {
            NoteScreen(navController = navController)
        }
    }
}