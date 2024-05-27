package com.jsoft.myapplication.coreui.composable.base.viewpager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jsoft.myapplication.coreui.composable.base.texts.Text14sp
import com.jsoft.myapplication.coreui.theme.TheAppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ColumnScope.HorizontalPagerWithTabRow(
    list: List<String>,
    content: @Composable PagerScope.(page: Int) -> Unit
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
    ) {
        list.size
    }
    val coroutineScope = rememberCoroutineScope()

    Column(
        Modifier
            .weight(1f), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .padding(horizontal = 1.dp),
//                        .pagerTabIndicatorOffset(pagerState, tabPositions),
                    color = TheAppTheme.colors.indicatorTint
                )
            },
        ) {
            list.forEachIndexed { index, title ->
                val selected = pagerState.currentPage == index
                Tab(
                    modifier = Modifier
                        .background(TheAppTheme.colors.primary),
                    text = {
                        Text14sp(
                            text = title,
                            color = if (selected) TheAppTheme.colors.primaryText else
                                TheAppTheme.colors.secondaryText
                        )
                    },
                    selected = selected,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                )
            }
        }

        HorizontalPager(state = pagerState) { page ->
            content(page)
        }
    }
}

