package com.arvind.jetinsta.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arvind.jetinsta.R
import com.arvind.jetinsta.ui.theme.Black
import com.guru.fontawesomecomposelib.FaIcon

@Composable
fun TopAppBarWithBackChat(onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBackClick() }) {
            Icon(
                imageVector = Icons.Default.KeyboardBackspace,
                contentDescription = "On Back",
                tint = Black,
                modifier = Modifier.size(32.dp, 32.dp)

            )
        }

        Text(
            text = "meshramaravind",
            maxLines = 1,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(120.dp),
            fontSize = 16.sp
        )

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = ""
            )

        }

        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.video_call),
                contentDescription = "Video Call Icon",
                tint = Black,
                modifier = Modifier.size(32.dp, 32.dp)
            )

        }

        IconButton(onClick = { }) {
            FaIcon(
                faIcon = FaIcons.EditRegular,
                tint = MaterialTheme.colors.onSurface,
                modifier = Modifier.size(32.dp, 32.dp)
            )

        }

    }
}