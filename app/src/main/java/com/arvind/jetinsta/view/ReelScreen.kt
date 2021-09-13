package com.arvind.jetinsta.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.arvind.jetinsta.R
import com.arvind.jetinsta.components.ReelsVideoPlayer
import com.arvind.jetinsta.data.Reel
import com.arvind.jetinsta.data.ReelsData
import com.arvind.jetinsta.ui.theme.Black
import com.skydoves.landscapist.glide.GlideImage

val verticalPadding = 12.dp
val horizontalPadding = 10.dp

@Preview(showBackground = true)
@Composable
fun ReelScreen() {
    Box(modifier = Modifier.background(color = Black)) {
        ReelsList()
        ReelsHeader()
    }
}


@Composable
fun ReelsList() {
    val reels = ReelsData.reels


    LazyColumn {

        items(reels.size) { index ->
            Box(
                modifier = Modifier.fillParentMaxSize(),
            ) {

                ReelsVideoPlayer(uri = reels[index].getVideoUrl())

                Column(
                    modifier = Modifier.align(Alignment.BottomStart),
                ) {
                    ReelFooter(reel = reels[index])
                    Divider()
                }
            }
        }
    }

}


@Composable
fun ReelsHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = horizontalPadding,
                vertical = verticalPadding
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "Reels", color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 21.sp
        )
        Icon(
            imageVector = Icons.Default.Camera,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ReelFooter(reel: Reel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 18.dp, bottom = 18.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        FooterUserData(reel = reel, modifier = Modifier.weight(8f))
        FooterUserAction(reel = reel, modifier = Modifier.weight(2f))
    }
}


@Composable
fun FooterUserData(
    reel: Reel,
    modifier: Modifier
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        // user data
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            GlideImage(
                imageModel = reel.userImage,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(28.dp)
                    .background(color = Color.Gray, shape = CircleShape)
                    .clip(CircleShape),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(horizontalPadding))
            Text(
                text = reel.userName,
                color = Color.White,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.width(horizontalPadding))
            Canvas(modifier = Modifier.size(5.dp), onDraw = {
                drawCircle(
                    color = Color.White,
                    radius = 8f
                )
            })
            Spacer(modifier = Modifier.width(horizontalPadding))
            Text(
                text = "Follow",
                color = Color.White,
                style = MaterialTheme.typography.subtitle2
            )


        }

        Spacer(modifier = Modifier.height(horizontalPadding))

        // comment
        Text(text = "wkwkwkwk... 😄", color = Color.White)

        Spacer(modifier = Modifier.height(horizontalPadding))

        // Audio
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(reel.userName, color = Color.White)
            Spacer(modifier = Modifier.width(horizontalPadding))
            Canvas(modifier = Modifier.size(5.dp), onDraw = {
                drawCircle(
                    color = Color.White,
                    radius = 8f
                )
            })
            Spacer(modifier = Modifier.width(horizontalPadding))
            Text(
                text = "Audio asli",
                color = Color.White
            )
        }


    }

}

@Composable
fun FooterUserAction(
    reel: Reel,
    modifier: Modifier
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        UserActionWithText(
            drawableRes = R.drawable.ic_outlined_favorite,
            text = reel.likesCount.toString()
        )
        Spacer(modifier = Modifier.height(28.dp))
        UserActionWithText(
            drawableRes = R.drawable.ic_outlined_comment,
            text = reel.commentsCount.toString()
        )
        Spacer(modifier = Modifier.height(28.dp))
        UserAction(R.drawable.ic_dm)
        Spacer(modifier = Modifier.height(28.dp))
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null, tint = Color.White)
        Spacer(modifier = Modifier.height(28.dp))
        GlideImage(
            imageModel = reel.userImage,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(28.dp)
                .background(color = Color.Gray, shape = RoundedCornerShape(6.dp))
                .clip(RoundedCornerShape(6.dp)),
            contentDescription = null
        )

    }

}

@Composable
fun UserAction(@DrawableRes drawableRes: Int) {
    Icon(
        bitmap = ImageBitmap.imageResource(id = drawableRes),
        contentDescription = null,
        modifier = Modifier.size(26.dp)
    )

}

@Composable
fun UserActionWithText(
    @DrawableRes drawableRes: Int,
    text: String
) {
    Icon(
        ImageBitmap.imageResource(id = drawableRes),
        tint = Color.White,
        modifier = Modifier.size(28.dp),
        contentDescription = ""
    )
    Spacer(modifier = Modifier.height(6 .dp))
    Text(
        text = text,
        color = Color.White,
        fontSize = 13.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
private fun LoadingIndicator(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = Color.Gray,
            strokeWidth = 2.dp
        )
    }
}

