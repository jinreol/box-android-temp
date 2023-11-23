01.navi.kt

// ui.screens
//     HomeScreen

// ui.navigation
//    NavGraph.kt 
//    NavRoute.kt 


// MainActivity.kt 
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainScreen() }
    }
}

@Composable
private fun MainScreen() {
    ExampleMaterialDesignTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            NavGraph(navController = navController)
        }
    }
}

// NavGraph.kt 
@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(
        navHostController = navHostController,
        startDestination = NavRoute.Home.path  
    ) {
        addHomeScreen(navController, this)
    }
}

private fun addHomeScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuild) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {
        HomeScreen()
    }
}

// NavRoute.kt 
sealed class NavRoute(var path: String) {
    object Home: NavRoute('home')
}


// HomeScreen.kt

*
Badges badges

Bottom sheets bottomSheets
Buttons buttons
Cards cards
Carousel carousel
Checkbox checkbox
Chips chips
Date pickers datePickers
Dialogs dialogs
Divider divider
Lists lists
Menus menus
Navigation bar navigationBar
Navigation drawer navigationDrawer
Navigation rail navigationRail
Progress indicators progressIndicator
Radio button radioButton
Search search
Side sheets sideSheets
Sliders sliders
Snackbar snackbar
Switch switch
Tabs tabs
Text fields textfields
Time pickers timePickers
Tooltips tooltips
Top app bar topappbar
Bottom app bar bottomAppBar
*/
val itemList = listOf(
    ComponentItem(1, "Badges","badges"),
    ComponentItem(2, "Bottom sheets","bottomSheets"),
    ComponentItem(3, "Buttons","bottomSheets"),
    ComponentItem(4, "Cards","cards"),
    ComponentItem(5, "Carousel","carousel"),
    ComponentItem(6, "Checkbox","Checkbox"),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoScaffold() {
    Scaffold(
        topBar = { DemoTopAppBar() },
        bottomBar = { DemoBottomAppBar() }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(itemList) { item ->
                Text(item.title)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoTopAppBar() {
    CenterAlignedTopAppBar (
        title = {
            Text(
                text = "Centered TopAppBar",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
    )
}

@Composable
fun DemoBottomAppBar() {
    BottomAppBar(containerColor = MaterialTheme.colorScheme.surface,
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Localized description",
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description",
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Localized description",
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Localized description",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                Icon(
                    Icons.Filled.Add, "Localized description",
                )
            }
        }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    ExampleMaterialDesignTheme {
        DemoScaffold()
    }
