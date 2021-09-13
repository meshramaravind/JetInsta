package com.arvind.jetinsta.components


import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arvind.jetinsta.ui.theme.Black
import com.arvind.jetinsta.R
import com.arvind.jetinsta.view.*

@ExperimentalFoundationApi
@Composable
fun AppBottomNavigation(
    navController: NavController
) {
    val sectionState = remember { mutableStateOf(DashboardSection.Home) }
    val navItems = DashboardSection.values().toList()

    Scaffold(
        bottomBar = {
            BottomBar(
                items = navItems,
                currentSection = sectionState.value,
                onSectionSelected = { sectionState.value = it },
            )
        }) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Crossfade(
            modifier = modifier,
            targetState = sectionState.value
        )
        { section ->
            when (section) {
                DashboardSection.Home -> InstagramHomeScreen(navController)
            }
            when (section) {
                DashboardSection.Search -> SearchScreen()
            }
            when (section) {
                DashboardSection.Reel -> ReelScreen()
            }
            when (section) {
                DashboardSection.Notification -> NotificationScreen()
            }
            when (section) {
                DashboardSection.Profile -> ProfileScreen()
            }

        }
    }
}

@Composable
private fun BottomBar(
    items: List<DashboardSection>,
    currentSection: DashboardSection,
    onSectionSelected: (DashboardSection) -> Unit,
) {
    BottomNavigation(
        modifier = Modifier.height(50.dp),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(MaterialTheme.colors.background)
    ) {
        items.forEach { section ->

            val selected = section == currentSection

            val iconRes = if (selected) section.selectedIcon else section.icon

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = iconRes),
                        modifier = Modifier.size(24.dp),
                        contentDescription = "Bottom nav icons"
                    )
                },
                selected = selected,
                unselectedContentColor = Color.Gray,
                selectedContentColor = Black,
                onClick = { onSectionSelected(section) },
                alwaysShowLabel = false
            )
        }
    }
}

private enum class DashboardSection(
    val icon: Int,
    val selectedIcon: Int,
) {
    Home(R.drawable.home, R.drawable.home),
    Search(R.drawable.search_outline, R.drawable.search_outline),
    Reel(R.drawable.reel, R.drawable.reel),
    Notification(R.drawable.notification, R.drawable.notification),
    Profile(R.drawable.profile, R.drawable.profile)
}