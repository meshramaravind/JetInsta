package com.arvind.jetinsta.components

import FaIcons
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.arvind.jetinsta.data.Story
import androidx.compose.ui.unit.dp
import com.arvind.jetinsta.ui.theme.Black
import com.guru.fontawesomecomposelib.FaIcon
import kotlinx.coroutines.launch


@Composable
fun InstagramListItem(post: Story) {
    Column {
        ProfileInfoSection(post)
        InstagramImage(imageId = post.storyImageId)
        InstagramIconSection()
        InstagramLikesSection(post)
        Text(
            text = "View all ${post.commentsCount} comments",
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(start = 8.dp, top = 4.dp),
            color = Color.Gray
        )
        Text(
            text = "${post.time} ago",
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(start = 8.dp, top = 2.dp, bottom = 8.dp),
            color = Color.Gray
        )

    }
}


@Composable
fun ProfileInfoSection(post: Story) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = post.authorImageId),
            contentDescription = "",
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .clickable { },
            contentScale = ContentScale.Crop
        )
        Text(
            text = post.author,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .padding(8.dp)
                .weight(1f),
            textAlign = TextAlign.Start
        )
        IconButton(onClick = {

        }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More Menu"
            )

        }
    }

}

@Composable
fun InstagramImage(imageId: Int) {
    if (imageId != 0) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)

        )
    }

}

@Composable
fun InstagramIconSection() {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        var fav by remember { mutableStateOf(false) }

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconToggleButton(checked = fav, onCheckedChange = {
                fav = it
            }) {
                val icon = if (fav) FaIcons.Heart else FaIcons.HeartRegular
                val tint = if (fav) Color.Red else MaterialTheme.colors.onBackground
                FaIcon(
                    faIcon = icon,
                    tint = tint,
                )
            }
            IconToggleButton(checked = false,
                onCheckedChange = {}) {
                FaIcon(
                    faIcon = FaIcons.CommentAltRegular,
                    tint = MaterialTheme.colors.onSurface
                )
            }

            IconToggleButton(checked = false,
                onCheckedChange = {}) {
                FaIcon(
                    faIcon = FaIcons.PaperPlaneRegular,
                    tint = MaterialTheme.colors.onSurface
                )

            }
        }

        IconToggleButton(checked = false,
            onCheckedChange = {}) {
            FaIcon(
                faIcon = FaIcons.BookmarkRegular,
                tint = MaterialTheme.colors.onSurface
            )

        }


    }
}

@Composable
fun InstagramLikesSection(post: Story) {

    Row(
        modifier = Modifier
            .padding(start = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = post.authorImageId),
            contentDescription = "",
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            buildAnnotatedString {
                append("Liked by ")
                withStyle(
                    style = SpanStyle(
                        color = Black,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("${post.author} ")
                }
                append("and ")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Black
                    )
                ) {
                    append("${post.likesCount} ")
                }
                append("others")

            },
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(start = 8.dp)
        )

    }
}
