package com.arvind.jetinsta.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arvind.jetinsta.data.DataDummy
import com.arvind.jetinsta.data.Story
import com.arvind.jetinsta.ui.theme.Black
import com.arvind.jetinsta.ui.theme.darkgray

@Preview(showBackground = true)
@Composable
fun InstagramChatList() {
    val chats = remember { DataDummy.storyList }

    LazyColumn(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
        items(chats) {
            ChatListItem(chat = it)
        }
    }

}

@Composable
fun ChatListItem(chat: Story) {
    val imagemodifier = if (chat.id == 1) {

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
            .clickable { }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(id = chat.authorImageId),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = imagemodifier
        )
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .weight(0.7f)
                .wrapContentHeight()
                .padding(10.dp)
        ) {
            Text(
                text = chat.author, style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center,
                color = Black
            )
            Text(
                text = chat.time, style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center
            )

        }

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Outlined.CameraAlt,
                contentDescription = "Camera",
                tint = darkgray,
                modifier = Modifier.size(32.dp, 32.dp)
            )
        }
    }


}
