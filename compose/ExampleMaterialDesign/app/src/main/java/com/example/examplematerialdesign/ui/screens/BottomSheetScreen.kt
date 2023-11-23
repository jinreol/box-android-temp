package com.example.examplematerialdesign.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.examplematerialdesign.ui.common.CommonScaffold
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "Bottom Sheet", popBackStack = popBackStack) {
        BottomSheetView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetView() {
    Column {
        val scope = rememberCoroutineScope()
        val scaffoldState = rememberBottomSheetScaffoldState()

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetPeekHeight = 128.dp,
            sheetContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(128.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Swipe up to expand sheet")
                }
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(64.dp), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Sheet content")
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = {
                        scope.launch { scaffoldState.bottomSheetState.partialExpand() }
                    }) {
                        Text("Click to collapse sheet")
                    }
                }
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Text("Scaffold Content")
            }
        }
    }
}