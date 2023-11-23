// 05-md-assistchip.kt

    ComponentItem(1, "Alert Dialog", "alertDialog"),
    ComponentItem(2, "Assist Chip", "assistChip"),
    ComponentItem(3, "Badges", "badge"),
    ComponentItem(4, "Bottom sheets", "bottomSheet"),
    ComponentItem(5, "Buttons", "button"),
    ComponentItem(6, "Cards", "card"),
    ComponentItem(7, "Carousel", "carousel"),
    ComponentItem(8, "Checkbox", "checkbox"),



// AssistChipScreen.kt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssistChipScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "Asisst Chip", popBackStack = popBackStack) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            AssistChipView()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssistChipView() {
    AssistChip(
        onClick = { /* Do something! */ },
        label = { Text("Assist Chip") },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized description",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        }
    )
}

