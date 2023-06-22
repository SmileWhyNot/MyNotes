package com.example.mynotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mynotes.MainViewModel
import com.example.mynotes.screens.AddScreen
import com.example.mynotes.screens.MainScreen
import com.example.mynotes.screens.NoteScreen
import com.example.mynotes.screens.StartScreen
import com.example.mynotes.utils.Constants
import com.example.mynotes.utils.Constants.Screens.ADD_SCREEN
import com.example.mynotes.utils.Constants.Screens.MAIN_SCREEN
import com.example.mynotes.utils.Constants.Screens.NOTE_SCREEN
import com.example.mynotes.utils.Constants.Screens.START_SCREEN

sealed class NavRoute(val route: String){
    object Start: NavRoute (START_SCREEN)
    object Main: NavRoute (MAIN_SCREEN)
    object Add: NavRoute (ADD_SCREEN)
    object Note: NavRoute (NOTE_SCREEN)
}

@Composable
fun NotesNavHost(mViewModel: MainViewModel, navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route) {
            StartScreen(navController = navController, viewModel = mViewModel)
        }
        composable(NavRoute.Main.route) {
            MainScreen(navController = navController, viewModel = mViewModel)
        }
        composable(NavRoute.Add.route) {
            AddScreen(navController = navController, viewModel = mViewModel)
        }
        composable(NavRoute.Note.route + "/{${Constants.Keys.ID}}") {backStackEntry ->
            NoteScreen(navController = navController, viewModel = mViewModel, noteId = backStackEntry.arguments?.getString(Constants.Keys.ID))
        }
    }
}