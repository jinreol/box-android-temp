02.kt

코루틴은 스레드 대체
동작이 종료되면 코루틴도 종료 

coroutineScope.launch {
    showEditMessage()
}

suspend fun showEditMessage() {
    if (!editMessageShow) {
        editMessageShow = true 
        delay(3000L)
        editMessageShow = false
    }
}

