package com.example.examplenavigate.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.examplenavigate.ui.common.DefaultButton

@Composable
fun HomeScreen(
    navigateToProfile: (Int, Boolean) -> Unit,
    navigateToSearch: (String) -> Unit,
    popBackStack: () -> Unit,
    popUpToLogin: () -> Unit
) {
    Column() {
        Text(text = "Home Screen", fontSize = 40.sp)

        DefaultButton(
            text = "Profile",
            onClick = { navigateToProfile(7, true) }
        )

        DefaultButton(
            text = "Search",
            onClick = { navigateToSearch("love doll") }
        )

        DefaultButton(
            text = "Back",
            onClick = popBackStack
        )

        DefaultButton(
            text = "Log Out",
            onClick = popUpToLogin
        )
    }
}

