// https://github.com/Foso/Jetpack-Compose-Playground/blob/master/app/src/main/java/de/jensklingenberg/jetpackcomposeplayground/mysamples/github/material/alertdialog/AlertDialogSample.kt

package com.example.examplematerialdesign.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.examplematerialdesign.ui.common.CommonScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "Alert Dialog", popBackStack = popBackStack) {
        AlertDialogView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val openDialog = remember { mutableStateOf(false) }

        Button(onClick = { openDialog.value = true }) {
            Text("Click me")
        }

        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = { /*TODO*/ },
                title = {
                    Text("Title")
                },
                text = {
                    "This area typically contains the supportive text " +
                            "which presents the details regarding the Dialog's purpose."
                },
                confirmButton = {
                    TextButton(onClick = { openDialog.value = false }) {
                        Text("Confirm Button")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { openDialog.value = false }) {
                        Text("Dismiss Button")
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AlertDialogViewPreview() {
    AlertDialogView()
}