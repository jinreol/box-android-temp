package com.example.examplematerialdesign.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.examplematerialdesign.ui.common.CommonScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssistChipScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "Assist Chip", popBackStack = popBackStack) {
        AssistChipView(popBackStack)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssistChipView(popBackStack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AssistChip(
            onClick = popBackStack,
            label = { Text("Assist Chip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = "Localized description",
                    Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        )
    }
}
