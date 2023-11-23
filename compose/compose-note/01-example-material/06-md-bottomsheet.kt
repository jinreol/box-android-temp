


import androidx.compose.material3.rememberBottomSheetScaffoldState
Unresolved reference: rememberBottomSheetScaffoldState


// 06-md-bottomsheet.kt
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadgeScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "Badge", popBackStack = popBackStack) {
        BottomSheetView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val scope = rememberCoroutineScope()
        val scaffoldState = rememberBottomSheetScaffoldState()

        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetPeekHeight = 128.dp,
            sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(128.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Swipe up to expand sheet")
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(64.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Sheet content")
                Spacer(Modifier.height(20.dp))
                Button(
                    onClick = {
                        scope.launch { scaffoldState.bottomSheetState.partialExpand() }
                    }
                ) {
                    Text("Click to collapse sheet")
                }
            }
        }) { innerPadding ->
            Box(Modifier.padding(innerPadding)) {
                Text("Scaffold Content")
            }
        }

    }
}
