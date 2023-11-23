package com.example.examplematerialdesign.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.examplematerialdesign.ui.common.CommonScaffold

@Composable
fun ButtonScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "Button", popBackStack = popBackStack) {
        ButtonView()
    }
}

@Composable
fun ButtonView() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column {
            Text("Filled Button:")
            Button(onClick = { /* Do something! */ }) { Text("Filled Button") }
        }

        Column {
            Text("Outlined Button:")
            OutlinedButton(onClick = { /* Do something! */ }) { Text("Outlined Button") }
        }

        Column {
            Text("Elevated Button:")
            ElevatedButton(onClick = { /* Do something! */ }) { Text("Elevated Button") }
        }

        Column {
            Text("Text Button:")
            TextButton(onClick = { /* Do something! */ }) { Text("Text Button") }
        }

        Column {
            Text("Filled Tonal Button:")
            FilledTonalButton(onClick = { /* Do something! */ }) { Text("Filled Tonal Button") }
        }
    }
}