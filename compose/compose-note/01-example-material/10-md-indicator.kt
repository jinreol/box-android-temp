// 10-md-indicator.kt

val itemList = listOf(
    ComponentItem(1, "Alert Dialog", "alertDialog"),
    ComponentItem(2, "Assist Chip", "assistChip"),
    ComponentItem(3, "Badges", "badge"),
    ComponentItem(4, "Bottom Sheets", "bottomSheet"),
    ComponentItem(5, "Buttons", "button"),
    ComponentItem(6, "Cards", "card"),
    ComponentItem(7, "Carousel", "carousel"),
    ComponentItem(8, "Checkbox", "checkbox"),
    ComponentItem(9, "CircularProgressIndicator", "circularProgressIndicator"),
)

sealed class NavRoute(var path: String) {
//...
    object CircularProgressIndicator: NavRoute("circularProgressIndicator")
}


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Home.path
    ) {
        addCircularProgressIndicatorScreen(navController, this)
    }
}

private fun addCircularProgressIndicatorScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Checkbox.path) {
        CircularProgressIndicatorScreen(popBackStack = {
            navHostController.popBackStack()
        })
    }
}


// CircularProgressIndicatorScreen.kt
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CircularProgressIndicatorScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "CircularProgressIndicator", popBackStack = popBackStack) {
        Text(text = "Carousel In progress")
    }
}

fun CircularProgressIndicatorView() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CircularProgressIndicator()
    }
}