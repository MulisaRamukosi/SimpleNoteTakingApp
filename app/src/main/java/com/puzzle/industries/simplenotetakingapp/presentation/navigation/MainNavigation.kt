package com.puzzle.industries.simplenotetakingapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.puzzle.industries.simplenotetakingapp.businessLogic.viewModels.NoteViewModel
import com.puzzle.industries.simplenotetakingapp.presentation.navigation.constants.MainScreens
import com.puzzle.industries.simplenotetakingapp.presentation.navigation.constants.RouteParamKeys
import com.puzzle.industries.simplenotetakingapp.presentation.navigation.constants.Routes
import com.puzzle.industries.simplenotetakingapp.presentation.screens.HomeScreen
import com.puzzle.industries.simplenotetakingapp.presentation.screens.NoteScreen

@Composable
fun MainNavigation(noteViewModel: NoteViewModel = viewModel()) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainScreens.Home.name
    ) {

        composable(route = Routes.Home.path) {
            HomeScreen(navController = navController, noteViewModel = noteViewModel)
        }

        composable(
            route = Routes.Note.path,
            arguments = listOf(navArgument(name = RouteParamKeys.NoteId.name) {
                type = NavType.StringType
                defaultValue = ""
            })
        ) { backStackEntry ->
            NoteScreen(
                navController = navController,
                noteViewModel = noteViewModel,
                noteId = backStackEntry.arguments?.getString(RouteParamKeys.NoteId.name)
            )
        }

    }
}