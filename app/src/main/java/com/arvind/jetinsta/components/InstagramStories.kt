package com.arvind.jetinsta.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.arvind.jetinsta.data.DataDummy
import androidx.compose.ui.unit.dp
import com.arvind.jetinsta.data.Story
import com.arvind.jetinsta.ui.theme.White
import com.arvind.jetinsta.ui.theme.instagramGradient

@Preview(showBackground = true)
@Composable
fun InstagramStories() {
    val posts = remember { DataDummy.storyList }

    LazyRow(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
        items(posts) {
            StoryListItem(post = it)
        }
    }
}

@Composable
fun StoryListItem(post: Story) {
    val imagemodifier = if (post.id == 1) {

        Modifier
            .padding(start = 8.dp, end = 8.dp, top = 8.dp)
            .width(60.dp)
            .height(60.dp)
            .clip(CircleShape)
            .clickable { }
    } else {
        Modifier
            .padding(start = 8.dp, end = 8.dp, top = 8.dp)
            .width(60.dp)
            .height(60.dp)
            .clip(CircleShape)
            .border(
                shape = CircleShape,
                border = BorderStroke(
                    width = 3.dp,
                    brush = Brush.linearGradient(
                        colors = instagramGradient,
                        start = Offset(0f, 0f),
                        end = Offset(100f, 100f)
                    )
                )
            )
            .clickable { }
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = post.authorImageId),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = imagemodifier
        )
        Text(
            text = post.author, style = typography.caption,
            textAlign = TextAlign.Center
        )

    }
}
