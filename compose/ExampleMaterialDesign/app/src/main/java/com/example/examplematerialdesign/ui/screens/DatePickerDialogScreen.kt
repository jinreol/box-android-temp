package com.example.examplematerialdesign.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.examplematerialdesign.ui.common.CommonScaffold
import kotlinx.coroutines.launch

@Composable
fun DatePickerDialogScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "DatePickerDialog", popBackStack = popBackStack) {
        DatePickerDialogView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialogView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val snackState = remember { SnackbarHostState() }
        val snakeScope = rememberCoroutineScope()
        SnackbarHost(hostState = snackState, Modifier)
        val openDialog = remember { mutableStateOf(true) }

        if (openDialog.value) {
            val datePickerState = rememberDatePickerState()
            val confirmEnabled =
                remember { derivedStateOf { datePickerState.selectedDateMillis != null } }
            DatePickerDialog(
                onDismissRequest = { openDialog.value = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                            snakeScope.launch {
                                snackState.showSnackbar(
                                    "Selected date timestamp: ${datePickerState.selectedDateMillis}"
                                )
                            }
                        },
                        enabled = confirmEnabled.value
                    ) {
                        Text("Ok")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        }
                    ) {
                        Text("Cancel")
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }

    }
}