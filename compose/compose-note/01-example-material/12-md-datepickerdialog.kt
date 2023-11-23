// 12-md-datepickerdialog.kt

// HomeScreen.kt
val itemList = listOf(
//....
    ComponentItem(11, "DatePickerDialog", "datePickerDialog"),
)

// NavRoute.kt
sealed class NavRoute(var path: String) {
    object DatePickerDialog : NavRoute("datePickerDialog")
}

// NavGraph.kt

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Home.path
    ) {
        addDatePickerDialogScreen(navController, this)
    }
}

private fun addDatePickerDialogScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.DatePicker.path) {
        DatePickerDialogScreen(popBackStack = {
            navHostController.popBackStack()
        })
    }
}

// DatePickerDialogScreen.kt 

private fun DatePickerDialogScreen

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
        // Decoupled snackbar host state from scaffold state for demo purposes.
        val snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()
        SnackbarHost(hostState = snackState, Modifier)
        val openDialog = remember { mutableStateOf(true) }
        // TODO demo how to read the selected date from the state.
        if (openDialog.value) {
            val datePickerState = rememberDatePickerState()
            val confirmEnabled = derivedStateOf { datePickerState.selectedDateMillis != null }
            DatePickerDialog(
                onDismissRequest = {
                    // Dismiss the dialog when the user clicks outside the dialog or on the back
                    // button. If you want to disable that functionality, simply use an empty
                    // onDismissRequest.
                    openDialog.value = false
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                            snackScope.launch {
                                snackState.showSnackbar(
                                    "Selected date timestamp: ${datePickerState.selectedDateMillis}"
                                )
                            }
                        },
                        enabled = confirmEnabled.value
                    ) {
                        Text("OK")
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