package com.example.examplematerialdesign.ui.screens

import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.examplematerialdesign.ui.common.CommonScaffold

@Composable
fun DatePickerScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "DatePicker", popBackStack = popBackStack) {
        DatePickerView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerView() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        val datePickerState = rememberDatePickerState(initialSelectedDateMillis = 1578096000000)
        DatePicker(state = datePickerState, modifier = Modifier.padding(16.dp))

        Text("Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}\"")
    }
}

