
// HomeScreen.kt 

enum class SunflowerPage() {
    @StringRes val titleResId: Int,
    @DrawableRes val drawableResId: Int
} {
    MY_GARDEN(R.string.my_garden_title, R.drawable.ic_my_garden_active),
    PLANT_LIST(R.string.plant_list_title, R.drawable.ic_plant_list_active)
}



@Composable
fun HomeScreen() {
    var pagerState = rememberPagerState()

    HomePagerScreen(
        pagerState = pagerState
    ) {
        HomePagerScreen(pagerState = pagerState)
    }
}


@Composable
fun HomePagerScreen(
    pages: Array<SunflowerPage> = SunflowerPage.values(),
    pagerState: PagerState
) {
    LaunchedEffect(pagerState.currentPager) {
        onPageChange(pages[pagerState.currentPager])
    }

    Column {
        TabRow(selectedTabIndex = pagerState.currentPage) {
            pages.forEachIndexed { index, page -> 
                val title stringResource(id = page.titleResId)
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                    text = { Text(text = title) },
                    icon = {
                        Icon(
                            painter = painterResource(id = page.drawableResId),
                            contentDescription = title
                        )
                    },
                    unselectedContentColor = MaterialTheme.colors.primaryVariant,
                    selectedContentColor = MaterialTheme.colors.secondary,
                )

            }
        }

        // Pages
        HorizontalPager(
        ) { index -> 
            when (pages[index]) {
                SunflowerPage.MY_GARDEN -> {
                    GardenScreen()
                }

                SunflowerPage.PLANT_LIST -> {
                    PlantListScreen()
                }
            }
        }

    }
}

