package com.example.examplematerialdesign.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.examplematerialdesign.ui.common.CommonScaffold

@Composable
fun CircularProgressIndicatorScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "CircularProgressIndicator", popBackStack = popBackStack) {
        CircularProgressIndicatorView()
    }
}

@Composable
fun CircularProgressIndicatorView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}