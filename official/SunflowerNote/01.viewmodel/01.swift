01.swift

// https://velog.io/@wlsrhkd4023/Compose-hiltViewModel%EA%B3%BC-viewModel-%EC%B0%A8%EC%9D%B4


@Composable 
private fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
    //....
) {
    //....
}

@HiltViewModel
class HomeViewModel @Inject contructor: ViewModel()

//-----------------------------------------------------------------------------------------------

// compose/home/HomeScreen.kt
@Composable 
fun HomePagerScreen(
    gardenPlantingListViewModel: GardenPlantingListViewModel = hiltViewModel(),
) {
    // plantAndGardenPlantings 데이터 가져오기
    val gardenPlants by gardenPlantingListViewModel.plantAndGardenPlantings.collectAsState(initial = emptyList())
}

// viewModel.GardenPlantingListViewModel
@HiltViewModel 
class GardenPlantingListViewModel @Inject internal contructor(
    gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {
    val plantAndGardenPlantings: Flow<List<PlantAndGardenPlantings>> =
        gardenPlantingRepository.getPlantedGardens()
}

// data/GardenPlantingRepository 
@Singleton
class GardenPlantingRepository @Inject constructor(
    private val gardenPlantingDao: GardenPlantingDao
) {
    fun getPlantedGardens() = gardenPlantingDao.getPlantedGardens()
}

// data/GardenplantingDao
@Dao 
interface GardenPlantingDao {
    @Query("SELECT * FROM garden_plantings")
    fun getGardenPlantings(): Flow<List<PlantAndGardenPlantings>>
}









