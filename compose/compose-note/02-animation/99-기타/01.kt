// 01.kt

// AnimationCodeLab - Home.kt - Tab

// 안드로이드는 Enum을 이렇게 지정하는구나 
private enum class TabPage {
    Home, Work
}

@Composable
fun Home() {
    var tabPage by remember { mutableStateOf(TabPage.Home) } // 탭을 Enum에 저장한다. 

    val backgroundColor = if (tabPage == TabPage.Home) Purple100 else Green300

    Scaffold(
        topBar = {
            HomeTabBar( //? 
                backgroundColor = backgroundColor,
                tabPage = tabPage,
                onTabSelected = { tabPage = it }
            )
        },
        backgroundColor = backgroundColor,
        floatingActionButton = {
            HomeFloatingActionButton(
                extended = lazyListState.isScrollingUp(),
                onClick = {
                    coroutineScope.launch { 
                        showEditMessage()
                    }
                }
            )   
        }
    ) { padding ->
        // 알맹이를채움

    }


}

// TabRow는 Tab을 나열하기 위한 컴포즈 함수구나
@Composable 
private fun HomeTabBar(
    backgroundColor: Color, 
    tabPage: TabPage, 
    onTabSelected: (tabPage: TabPage) -> Unit 
) {
    TabRow(
        selectedTabIndex = tabPage.ordinal, // swift에서 rawValue과 같은 개념이구나 
        backgroundColor = backgroundColor,
        indicator = { tabPositions -> 
            HomeTabIndicator(tabPositions, tabPage)
        }
    ) { 
        HomeTab(
            icon = Icons.Default.Home, 
            title = stringResrouce("Home"),
            onClick = { onTabSelected(TabPage.Home) }
        )
        HomeTab(
            icon = Icons.Default.AccountBox,
            title = stringResrouce("Work")
            onClick = { onTabSelected(TagPage.Work) }
        )
    }
}

@Composable 
private fun HomeTab(
    icon: ImageVector,
    title: String, 
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        horizontalAlignment = Arrangement.Center,
        verticalAligment = Alignment.CenterVertically
    ) {
        Icon(
            ImageVector = icon, 
            contentDescription = null
        )
        Spacer(modifier = Modifier.witdh(16.dp))
        Text(text = title)
    }
}

// 탭 외각형 박스 아웃라인을 그린다.
@Composable 
private fun HomeTabIndicator( 
    tabPosition: List<TabPosition>,
    tabPage: TabPage
) {
    val indicatorLeft = tabPosition[tabPage.ordinal].left // 왼쪽 패팅
    val indicatorRight = tabPosition[tabPage.ordinal].right  // 오른쪽 패팅
    val color = if (tabPage = TabPage.Home) Purple700 else Green800
    Box(
        Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomStart)
            .offset(x = indicatorLeft)
            .width(indicatorRight - indicatorLeft)
            .padding(4.dp)
            .fillMaxSize()
            .border(
                BorderStroke(2.dp, color),
                RoundedCornerShape(4.dp)
            )
    )
}