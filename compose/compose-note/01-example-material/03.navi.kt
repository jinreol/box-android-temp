// 03.navi.kt


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            LazyColumn(modifier = Modifier.padding(horizontal = 20.dp)) {
                items(itemList) { item ->
                    Button(
                        modifier = Modifier.padding(20.dp),
                        onClick = { navigateTo(item.route) }) {
                        Text(item.title)
                    }
                }
            }
        }
        
//ui.common 
//    CommonScaffold.kt 
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonScreen(
    title: String, 
    popBackStack: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { CommmonTopAppBar(title = title, popBackStack = popBackStack) },
        bottomBar = { DemoBottomAppBar() },
        content = content
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommmonTopAppBar(title: String, popBackStack: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Back,
                    contentDescription = "Back Button",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Account,
                    contentDescription = "Localized description",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonBottomAppBar() {
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
