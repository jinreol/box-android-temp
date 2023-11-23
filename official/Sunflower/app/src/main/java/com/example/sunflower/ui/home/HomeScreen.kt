package com.example.sunflower.ui.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.sunflower.R
import com.example.sunflower.ui.garden.EmptyGarden
import kotlinx.coroutines.launch

enum class SunflowerPage(
    @StringRes val titleResId: Int,
    @DrawableRes val drawableResId: Int
) {
    MY_GARDEN(R.string.my_garden_title, R.drawable.ic_my_garden_active),
    PLANT_LIST(R.string.plant_list_title, R.drawable.ic_plant_list_active)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val pagerState = rememberPagerState()
    HomePagerScreen(pagerState = pagerState)
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePagerScreen(
    onPageChange: (SunflowerPage) -> Unit = {},
    pages: Array<SunflowerPage> = SunflowerPage.values(),
    pagerState: PagerState,
//    gardenPlantingListViewModel: GardenPlantingListViewModel = hiltViewModel()
) {
//    val gardenPlantings by gardenPlantingListViewModel.plantAndGardenPlantings.collectAsState(
//        initial = emptyList()
//    )

    LaunchedEffect(pagerState.currentPage) {
        onPageChange(pages[pagerState.currentPage])
    }

    Column {
        val coroutineScope = rememberCoroutineScope()

        // Tab Row
        TabRow(selectedTabIndex = pagerState.currentPage) {
            pages.forEachIndexed { index, page ->
                val title = stringResource(id = page.titleResId)
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
                    unselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    selectedContentColor = MaterialTheme.colorScheme.secondary
                )
            }
        }

        // Pages
        HorizontalPager(
            pageCount = pages.size,
            state = pagerState
        ) { index ->
            when (pages[index]) {
                SunflowerPage.MY_GARDEN -> {
                    EmptyGarden()
                }

                SunflowerPage.PLANT_LIST -> {
                    Text("Plant List")
                }
            }
        }
    }
}


