package com.example.examplematerialdesign.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.examplematerialdesign.ComponentItem

val itemList = listOf(
    ComponentItem(1, "Badges", "badge"),
//    ComponentItem(2, "Bottom app bar", ""),
    ComponentItem(3, "Bottom Sheets", "bottomSheet"),
    ComponentItem(4, "Buttons", "button"),
    ComponentItem(5, "Alert Dialog", "alertDialog"),
    ComponentItem(6, "Assist Chip", "assistChip"),

    ComponentItem(7, "Cards", "card"),
    ComponentItem(8, "Carousel", "carousel"),
    ComponentItem(9, "Checkbox", "checkbox"),
    ComponentItem(9, "CircularProgressIndicator", "circularProgressIndicator"),
    ComponentItem(10, "DatePicker", "datePicker"),
    ComponentItem(11, "DatePickerDialog", "datePickerDialog"),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateTo: (String) -> Unit,
) {
    Scaffold(
        topBar = { DemoTopAppBar() },
        bottomBar = { DemoBottomAppBar() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            LazyColumn(modifier = Modifier.padding(horizontal = 20.dp)) {
                items(itemList) { item ->
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { navigateTo(item.route) }) {
                        Text(item.title)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Material Design Component",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Localized description",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
    )
}

@Composable
fun DemoBottomAppBar() {
    BottomAppBar(containerColor = MaterialTheme.colorScheme.surface,
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Localized description",
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description",
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Localized description",
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Localized description",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                Icon(
                    Icons.Filled.Add, "Localized description",
                )
            }
        }
    )
}