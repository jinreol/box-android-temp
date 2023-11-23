// 01.kt

// 룸은 하나도 모른채 용감했구먼 ㅎㅎㅎ


// https://readystory.tistory.com/210

// data/AppDatabase.kt

@Database(
    entities = [GardenPlanting::class, Plant::class], version = 1, exportSchema = false 
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun GardenPlantingDao(): GardenPlantingDao
    abstract fun plantDao(): PlantDao 

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: AppDatabase? = null 

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this)
        }
    }
}



// -------------------------------------------------------------------------------------------

@Database(
    entities = [AlbumEntity::class],
    version = 1,
    exportSchema = false 
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun albumDao() : AlbumDao
}

@Dao 
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addAlbum(item: AlbumEntity)

    @Query("SELECT * FROM AlbumEntity")
    suspend fun getAllAlbums() : List<AlbumEntity>
}

@Entity 
data class AlbumEntity(
    @PrimaryKey(autoGenerate = true) val id: Int, 
    val name: String 
) {
    companion object {
        const val DEFAULT_ALBUM_ID = 1
        val DEFAULT_ALBUM = AlbumEntity(DEFAULT_ALBUM_ID, "기본 앨범")
    }
}


@InstallIn(SingletonComponent::class)
@Module
object DBModule {
    @Singleton 
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context 
    ) : AppDatabase = Room 
            .databaseBuilder(context, AppDatabase::class.java, "kim_ready.db")
            .build()


    @Singleton
    @Provides
    fun provideAlbumDao(appDatabase: AppDatabase): AlbumDao = appDatabase.album()
}

public abstract static class Callback {
    public void onCreate(@NonNull SupportSQLiteDatabase db) {}
    public void onOpen(@NonNull SupportSQLiteDatabase db) {}
    public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {}
}



