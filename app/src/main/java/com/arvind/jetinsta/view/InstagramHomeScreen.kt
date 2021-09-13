package com.arvind.jetinsta.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.arvind.jetinsta.R
import com.arvind.jetinsta.components.InstagramListItem
import com.arvind.jetinsta.components.InstagramStories
import com.arvind.jetinsta.data.DataDummy
import com.arvind.jetinsta.navigation.Screen


@Composable
fun InstagramHomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Instagram") },
            backgroundColor = MaterialTheme.colors.surface,
            contentColor = MaterialTheme.colors.onSurface,
            elevation = 8.dp,

            actions = {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = "",
                        tint = MaterialTheme.colors.onSurface,
                        modifier = Modifier.size(20.dp, 20.dp)
                    )
                }
                IconButton(onClick = {
                    navController.navigate(Screen.ChatListScreen.route)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.messenger),
                        contentDescription = "",
                        tint = MaterialTheme.colors.onSurface,
                        modifier = Modifier.size(20.dp, 20.dp)
                    )
                }
            }
        )
    },
        content = {
            InstagramHomeContent()
        })
}

@Composable
fun InstagramHomeContent() {
    Column {
        InstagramStories()
        Divider()
        InstagramPostsList()
    }

}

@Composable
fun InstagramPostsList() {
    val posts = remember {
        DataDummy.storyList.filter {
            it.storyImageId != 0
        }
    }

    LazyColumn {
        items(
            items = posts,
            itemContent = {
                InstagramListItem(post = it)
            })
    }
}


