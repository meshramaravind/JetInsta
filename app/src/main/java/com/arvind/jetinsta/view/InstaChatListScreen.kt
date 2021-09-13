package com.arvind.jetinsta.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.arvind.jetinsta.components.TopAppBarWithBackChat
import com.arvind.jetinsta.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun InstaChatListScreen() {
    var search by remember { mutableStateOf("") }
    Scaffold(topBar = {
        TopAppBarWithBackChat(
            onBackClick = {

            },
        )
    }, backgroundColor = bgwhitelight,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Column {
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.8f)
                            .padding(top = 20.dp, start = 10.dp, end = 10.dp, bottom = 10.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = lightgray,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        value = search,
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true,
                        onValueChange = { search = it },
                        placeholder = {
                            Text(
                                text = "Search",
                                color = darkgray
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "",
                                tint = darkgray
                            )
                        },
                    )
                    Spacer(modifier = Modifier.padding(10.dp))

                    InstaTab()
                }


            }
        }
    )
}

@ExperimentalPagerApi
@Composable
fun InstaTab() {
    val tabData = listOf(
        "Chats",
        "Rooms",
        "0 requests",
    )
    val pagerState = rememberPagerState(
        pageCount = tabData.size,
        initialOffscreenLimit = 2,
        infiniteLoop = true,
        initialPage = 0,
    )
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column {
        TabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = Color.Transparent,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            }
        ) {
            tabData.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = { Text(title) },
                )
            }
        }

        HorizontalPager(
            state = pagerState,
        ) { index ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = tabData[index])
            }
        }
    }
}
