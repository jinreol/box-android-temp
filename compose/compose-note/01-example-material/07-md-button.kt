// 07-md-button.kt


// ButtonScreen.kt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonScreen(popBackStack: () -> Unit) {
    CommonScaffold(title = "Assist Chip", popBackStack = popBackStack) {
        ButtonView(popBackStack)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonView(popBackStack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row {
            Text("Filled Button:")
            Button(onClick = { /* Do something! */ }) { Text("Filled Button") }
        }

        Row {
            Text("Outlined Button:")
            OutlinedButton(onClick = { /* Do something! */ }) { Text("Outlined Button") }
        }

        Row {
            Text("Elevated Button:")
            ElevatedButton(onClick = { /* Do something! */ }) { Text("Elevated Button") }
        }

        Row {
            Text("Text Button:")
            TextButton(onClick = { /* Do something! */ }) { Text("Text Button") }
        }

        Row {
            Text("Filled Tonal Button:")
            FilledTonalButton(onClick = { /* Do something! */ }) { Text("Filled Tonal Button") }
        }

    }

}
