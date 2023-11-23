package com.example.roomwordsample

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication: Application() {
    // No need to cancel this scope as it'll be torn down with process
    // 이 스코드는 뒤질때까지 취소되지 않는다.
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // 아래 데이터베이스는 생성되지 않다가 데이터베이스를 사용하는 시점에 초기화 된다.
    val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope)}
    val repository by lazy { WordRepository(database.wordDao())}
}
