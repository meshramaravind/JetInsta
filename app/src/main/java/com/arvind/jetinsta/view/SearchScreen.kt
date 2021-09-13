package com.arvind.jetinsta.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.arvind.jetinsta.R
import com.arvind.jetinsta.components.InstagramListItem
import com.arvind.jetinsta.data.DataDummy
import com.arvind.jetinsta.ui.theme.Black
import com.arvind.jetinsta.ui.theme.White
import com.arvind.jetinsta.ui.theme.darkgray
import com.arvind.jetinsta.ui.theme.lightgray
import kotlin.math.ceil

@Preview(showBackground = true)
@ExperimentalFoundationApi
@Composable
fun SearchScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column {
            SearchSection()
        }
    }
}


@Composable
fun SearchSection() {
    var search by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
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
                tint = Black
            )
        },
    )
}









