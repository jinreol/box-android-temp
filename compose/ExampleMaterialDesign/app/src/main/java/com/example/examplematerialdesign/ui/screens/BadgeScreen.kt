package com.example.examplematerialdesign.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.example.examplematerialdesign.ui.common.CommonScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadgeScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "Badge", popBackStack = popBackStack) {
        BadgeView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadgeView() {
    NavigationBar {
        NavigationBarItem(
            icon = {
                BadgedBox(
                    badge = {
                        Badge {
                            val badgeNumber = "8"
                            Text(
                                badgeNumber,
                                modifier = Modifier.semantics {
                                    contentDescription = "$badgeNumber new notifications"
                                }
                            )
                        }
                    }) {
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = "Favorite"
                    )
                }
            },
            selected = false,
            onClick = {}
        )
    }
}