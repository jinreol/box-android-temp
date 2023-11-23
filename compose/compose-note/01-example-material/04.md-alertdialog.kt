// 04.md-alertdialog.kt

// HomeScreen.kt 
val itemList = listOf(
    ComponentItem(1, "Alert Dialog", "alertDialog"),
    ComponentItem(2, "Badges", "badge"),
    ComponentItem(3, "Bottom sheets", "bottomSheet"),
    ComponentItem(4, "Buttons", "button"),
    ComponentItem(5, "Cards", "card"),
    ComponentItem(6, "Carousel", "carousel"),
    ComponentItem(7, "Checkbox", "checkbox"),
)

// NavRoute.kt 
sealed class NavRoute(var path: String) {
    object Home : NavRoute("home")

    object AlertDialog : NavRoute("alertDialog")
    object Badge : NavRoute("badge")
    object BottomSheet : NavRoute("bottomSheet")
    object Button : NavRoute("button")
    object Card : NavRoute("card")
    object Carousel : NavRoute("carousel")
    object Checkbox : NavRoute("checkbox")
}

// NavGraph.kt
private fun addHomeScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.AlertDialog.path) {
        AlertDialogScreen(navigateTo = { path ->
            navHostController.navigate(path)
        })
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "Badge", popBackStack = popBackStack) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            AlertDialogView()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogView() {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.
                openDialog.value = false
            }
        ) {
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "This area typically contains the supportive text " +
                            "which presents the details regarding the Dialog's purpose.",
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Confirm")
                    }
                }
            }
        }
    }
}