package com.arvind.jetinsta.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.arvind.jetinsta.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arvind.jetinsta.ui.theme.Black
import com.arvind.jetinsta.ui.theme.darkgray

@Preview(showBackground = true)
@Composable
fun MessageRequests() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = { },
            modifier = Modifier
                .then(Modifier.size(100.dp))
                .border(2.dp, Black, shape = CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.send),
                contentDescription = "",
                modifier = Modifier.size(35.dp, 35.dp)
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "No message requests",
            fontWeight = FontWeight.Bold,
            color = Black,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "You don't have any message\n" +
                    "request",
            color = darkgray,
            fontSize = 14.sp
        )

    }
}