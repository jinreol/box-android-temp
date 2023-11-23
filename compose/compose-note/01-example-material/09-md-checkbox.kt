// 09-md-checkbox.kt


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckBoxScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "CheckBox", popBackStack = popBackStack) {
        CardView()
    }
}

@Composable
fun CardView() {
    val (checkedState, onStateChange) = remember { mutableStateOf(true) }

    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .toggleable(
                value = checkedState,
                onValueChange = { onStateChange(!checkedState) },
                role = Role.Checkbox
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = null // null recommended for accessibility with screenreaders
        )
        Text(
            text = "Option selection",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}