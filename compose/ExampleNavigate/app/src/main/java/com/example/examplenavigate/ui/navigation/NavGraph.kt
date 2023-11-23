package com.example.examplenavigate.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.examplenavigate.ui.screens.HomeScreen
import com.example.examplenavigate.ui.screens.LoginScreen
import com.example.examplenavigate.ui.screens.ProfileScreen
import com.example.examplenavigate.ui.screens.SearchScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Login.path,
    ) {
        addLoginScreen(navController = navController, this)
        addHomeScreen(navController = navController, this)
        appProfileScreen(navController = navController, this)
        addSearchScreen(navController = navController, this)
    }
}

private fun addLoginScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Login.path) {
        LoginScreen(navigateToHome = {
            navController.navigate(NavRoute.Home.path)
        })
    }
}

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {
        HomeScreen(
            navigateToProfile = { id, showDetails ->
                navController.navigate(
                    NavRoute.Profile.withArgs(id.toString(), showDetails.toString())
                )
            },
            navigateToSearch = { query ->
                navController.navigate(NavRoute.Search.withArgs(query))
            },
            popBackStack = {
                navController.popBackStack()
            },
            popUpToLogin = {
                popUpToLogin(navController = navController)
            }
        )
    }
}

private fun appProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.withArgsFormat(
            NavRoute.Profile.id, NavRoute.Profile.showDetails
        ),
        arguments = listOf(
            navArgument(NavRoute.Profile.id) {
                type = NavType.IntType
            },
            navArgument(NavRoute.Profile.showDetails) {
                type = NavType.BoolType
            }
        )
    ) { navBackStackEntry ->
        val args = navBackStackEntry.arguments

        val id: Int = args?.getInt(NavRoute.Profile.id) ?: -1
        val showDetails: Boolean = args?.getBoolean(NavRoute.Profile.showDetails) ?: false

        Log.d("NavGraph", "id:$id showDetails:$showDetails")

        ProfileScreen(
            id = id,
            showDetails = showDetails,
            popBackStack = { navController.popBackStack() },
            popUpToLogin = { popUpToLogin(navController = navController) }
        )
    }
}

private fun addSearchScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Search.withArgsFormat(NavRoute.Search.query),
        arguments = listOf(
            navArgument(NavRoute.Search.query) {
                type = NavType.StringType
                nullable = true
            }
        ) 
    ) { navBackStackEntry ->  
        val args = navBackStackEntry.arguments
        
        SearchScreen(
            query = args?.getString(NavRoute.Search.query),
            popBackStack = { navController.popBackStack() },
            popUpToLogin = { popUpToLogin(navController = navController) }
        )
    }
}

private fun popUpToLogin(navController: NavHostController) {
    navController.popBackStack(NavRoute.Login.path, inclusive = false)
}