package com.arvind.jetinsta.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Report
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.arvind.jetinsta.ui.theme.Black

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun InstagramMenuBottomDialog() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed)
    )

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Divider(
                    color = Color.DarkGray,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(10.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(
                            onClick = { },
                            modifier = Modifier
                                .then(Modifier.size(50.dp))
                                .border(1.dp, Color.LightGray, shape = CircleShape)
                        ) {
                            Icon(
                                Icons.Default.Share,
                                contentDescription = "",
                                tint = Color.LightGray
                            )
                        }

                        Text(
                            text = "Share to...",
                            style = MaterialTheme.typography.caption,
                            textAlign = TextAlign.Center
                        )

                        IconButton(
                            onClick = { },
                            modifier = Modifier
                                .then(Modifier.size(50.dp))
                                .border(1.dp, Color.LightGray, shape = CircleShape)
                        ) {
                            Icon(
                                Icons.Default.Link,
                                contentDescription = "",
                                tint = Color.LightGray
                            )
                        }

                        Text(
                            text = "Copy Link",
                            style = MaterialTheme.typography.caption,
                            textAlign = TextAlign.Center
                        )

                        IconButton(
                            onClick = { },
                            modifier = Modifier
                                .then(Modifier.size(50.dp))
                                .border(1.dp, Color.Red, shape = CircleShape)
                        ) {
                            Icon(
                                Icons.Default.Report,
                                contentDescription = "",
                                tint = Color.Red
                            )
                        }

                        Text(
                            text = "Report",
                            color = Color.Red,
                            style = MaterialTheme.typography.caption,
                            textAlign = TextAlign.Center
                        )

                        Divider()
                        Text(
                            text = "Hide",
                            color = Black,
                            style = MaterialTheme.typography.caption,

                            )

                        Text(
                            text = "Turn on post Notifications",
                            color = Black,
                            style = MaterialTheme.typography.caption,

                            )

                        Text(
                            text = "Unfollow",
                            color = Black,
                            style = MaterialTheme.typography.caption,

                            )

                    }


                }
            }
        }, sheetPeekHeight = 0.dp
    ) {

    }

}