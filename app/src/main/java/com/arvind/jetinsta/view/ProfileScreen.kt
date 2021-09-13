package com.arvind.jetinsta.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.arvind.jetinsta.R
import com.arvind.jetinsta.model.ImageWithText
import com.arvind.jetinsta.ui.theme.Black
import com.arvind.jetinsta.ui.theme.White
import com.arvind.jetinsta.ui.theme.darkgray

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            name = "meshramaravind2015",
            modifier = Modifier
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.padding(10.dp))
        EditProfileButtonSection()
        Spacer(modifier = Modifier.padding(10.dp))
        PostTabView(
            imageWithTexts = mutableStateListOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.instagram_tag),
                    text = "Tag"
                ),

                )
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> PostSection(
                posts = mutableStateListOf(
                    painterResource(id = R.drawable.james),
                    painterResource(id = R.drawable.katy),
                    painterResource(id = R.drawable.khalid),
                    painterResource(id = R.drawable.lana),
                    painterResource(id = R.drawable.wolves),
                    painterResource(id = R.drawable.adele),
                    painterResource(id = R.drawable.adele21),
                    painterResource(id = R.drawable.dualipa),
                    painterResource(id = R.drawable.bp),
                    painterResource(id = R.drawable.camelia),
                    painterResource(id = R.drawable.tylor),
                    painterResource(id = R.drawable.shawn),
                ),
                modifier = Modifier.fillMaxWidth()
            )

            1 -> PhotosVideosTagSection()
        }

    }
}


@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Outlined.Lock,
            contentDescription = "user id",
            tint = Black,
            modifier = Modifier.size(20.dp)
        )
        TextButton(onClick = { }) {
            Text(
                text = name,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Black
            )

        }

        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(id = R.drawable.add),
                contentDescription = "",
                tint = Black,
                modifier = Modifier.size(20.dp)
            )
        }

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Black,
                modifier = Modifier.size(32.dp)
            )
        }
    }

}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        Spacer(modifier = Modifier.padding(4.dp))
        ProfileDescription(
            displayName = "Arvind Meshram",
            description = "IT\n" +
                    "5th March\n" +
                    "Android Developer",
            url = "https://github.com/meshramaravind",
        )

    }
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ProfileStat(numberText = "37", titleText = "Posts")
        ProfileStat(numberText = "159", titleText = "Followers")
        ProfileStat(numberText = "423", titleText = "Following")
    }

}

@Composable
fun ProfileStat(
    numberText: String,
    titleText: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = titleText)
    }

}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
    }

}

@Composable
fun EditProfileButtonSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedButton(
            onClick = { },
            border = BorderStroke(1.dp, Color.LightGray),
            modifier = Modifier
                .padding(8.dp)
                .weight(0.85f)
        ) {
            Text(
                text = "Edit Profile",
                fontWeight = FontWeight.Bold,
                color = Black
            )
        }

        OutlinedButton(
            onClick = { },
            border = BorderStroke(1.dp, Color.LightGray),
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowDown,
                contentDescription = null,
                tint = Black,
                modifier = Modifier.padding(end = 4.dp)
            )

        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)

    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }

    }

}

@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = White
                    )
            )
        }
    }

}

@Composable
fun PhotosVideosTagSection() {
    LazyColumn(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            IconButton(
                onClick = { },
                modifier = Modifier
                    .then(Modifier.size(100.dp))
                    .border(2.dp, Black, shape = CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.instagram_tag),
                    contentDescription = null,
                    modifier = Modifier.size(35.dp, 35.dp)
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Photos and\n" +
                        "videos of you",
                fontWeight = FontWeight.Bold,
                color = Black,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "When people tag you in photos and\n" +
                        "videos, they'll appear here.",
                color = darkgray,
                fontSize = 14.sp
            )
        }
    }

}




