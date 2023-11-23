package com.example.examplenavigate.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examplenavigate.ui.common.DefaultButton

@Composable
fun ProfileScreen(
    id: Int,
    showDetails: Boolean,
    popBackStack: () -> Unit,
    popUpToLogin: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Profile Id: $id", fontSize = 40.sp)
        
        Spacer(modifier = Modifier.height(5.dp))
        Text("Details: $showDetails", fontSize = 40.sp)

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