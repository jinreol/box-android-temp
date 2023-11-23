01.kt

https://developer.android.com/codelabs/jetpack-compose-animation?hl=ko#0

// 색깔 애니메이션 
val backgroundColor = if (tabPage == TabPage.Home) Purple100 else Green300

val backgroundColor by animateColorAsState(targetValue = if (tabPage == TabPage.Home) Purple100 else Green300,
    label = "Color Animation"
)

