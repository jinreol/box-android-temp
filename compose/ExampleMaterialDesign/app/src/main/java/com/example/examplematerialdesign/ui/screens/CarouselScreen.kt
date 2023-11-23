package com.example.examplematerialdesign.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.examplematerialdesign.ui.common.CommonScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "Carousel", popBackStack = popBackStack) {
        Text(text = "Carousel In progress")
    }
}