// 11-md-datepicker.kt

// DatePickerScreen.kt
@Composable
fun DatePickerScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "DatePicker", popBackStack = popBackStack) {
        DatePickerView()
    }
}

@Composable
fun DatePickerView() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        // Pre-select a date for January 4, 2020
        val datePickerState = rememberDatePickerState(initialSelectedDateMillis = 1578096000000)
        DatePicker(state = datePickerState, modifier = Modifier.padding(16.dp))

        Text("Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}")
    }
}

// NavGraph.kt
@Composable
fun NavGraph(navController: NavHostController) {
    addDatePickerScreen(navController, this)
}

private fun addDatePickerScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.DatePicker.path) {
        DatePickerScreen(navigateTo = { path ->
            navHostController.navigate(path)
        })
    }
}

// NavRoute.kt
sealed class NavRoute(var path: String) {
    object DatePicker : NavRoute("datePicker")
}

//  HomeScreen.kt
val itemList = listOf(
    ComponentItem(10, "DatePicker", "datePicker"),
)

