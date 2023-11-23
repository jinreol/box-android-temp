package com.example.examplematerialdesign.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.examplematerialdesign.ui.screens.AlertDialogScreen
import com.example.examplematerialdesign.ui.screens.AssistChipScreen
import com.example.examplematerialdesign.ui.screens.BadgeScreen
import com.example.examplematerialdesign.ui.screens.BottomSheetScreen
import com.example.examplematerialdesign.ui.screens.ButtonScreen
import com.example.examplematerialdesign.ui.screens.CardScreen
import com.example.examplematerialdesign.ui.screens.CarouselScreen
import com.example.examplematerialdesign.ui.screens.CheckBoxScreen
import com.example.examplematerialdesign.ui.screens.CircularProgressIndicatorScreen
import com.example.examplematerialdesign.ui.screens.DatePickerDialogScreen
import com.example.examplematerialdesign.ui.screens.DatePickerScreen
import com.example.examplematerialdesign.ui.screens.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Home.path
    ) {
        addHomeScreen(navController, this)
        addAlertDialogScreen(navController, this)
        addAssistChipScreen(navController, this)
        addBadgeScreen(navController, this)
        addBottomSheetScreen(navController, this)
        addButtonScreen(navController, this)
        addCardScreen(navController, this)
        addCarouselScreen(navController, this)
        addCheckBoxScreen(navController, this)
        addCircularProgressIndicatorScreen(navController, this)
        addDatePickerScreen(navController, this)
        addDatePickerDialogScreen(navController, this)
    }
}

private fun addHomeScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {
        HomeScreen(navigateTo = { path ->
            navHostController.navigate(path)
        })
    }
}

private fun addAlertDialogScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.AlertDialog.path) {
        AlertDialogScreen(popBackStack = {
            navHostController.popBackStack()
        })
    }
}

private fun addAssistChipScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.AssistChip.path) {
        AssistChipScreen(popBackStack = {
            navHostController.popBackStack()
        })
    }
}

private fun addBadgeScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Badge.path) {
        BadgeScreen(popBackStack = {
            navHostController.popBackStack()
        })
    }
}

private fun addBottomSheetScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.BottomSheet.path) {
        BottomSheetScreen(popBackStack = {
            navHostController.popBackStack()
        })
    }
}

private fun addButtonScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Button.path) {
        ButtonScreen(popBackStack = {
            navHostController.popBackStack()
        })
    }
}

private fun addCardScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Card.path) {
        CardScreen(popBackStack = {
            navHostController.popBackStack()
        })
    }
}

private fun addCarouselScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Carousel.path) {
        CarouselScreen(popBackStack = {
            navHostController.popBackStack()
        })
    }
}

private fun addCheckBoxScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Checkbox.path) {
        CheckBoxScreen(popBackStack = {
            navHostController.popBackStack()
        })
    }
}

private fun addCircularProgressIndicatorScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.CircularProgressIndicator.path) {
        CircularProgressIndicatorScreen(popBackStack = {
            navHostController.popBackStack()
        })
    }
}

private fun addDatePickerScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.DatePicker.path) {
        DatePickerScreen(popBackStack = {
            navHostController.popBackStack()
        })
    }
}


private fun addDatePickerDialogScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.DatePickerDialog.path) {
        DatePickerDialogScreen(popBackStack = {
            navHostController.popBackStack()
        })
    }
}
