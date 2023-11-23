
실패 liveData 에러가 난다


https://velog.io/@leeyjwinter/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-Retrofit-%EC%B4%88%EA%B8%B0%EC%84%A4%EC%A0%95%EA%B3%BC-%EC%8B%A4%ED%96%89


ef retrofit_version = "2.9.0"
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.10.0"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")


<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>


Albums.kt
class Albums : ArrayList<AlbumsItem>()

AlbumsItem.kt
data class AlbumsItem(
	@SerializedName("id")
	var id: Int, 
	@SerializedName("title")
	var title: String 
	@SerializedName("userId")
	var userId: Int 
)

interface AlbumService {
	@GET("/albums")
	suspend fun getAlbums() : Response<Albums>
}

class RetrofitInstance {
	companion object {
		val BASE_URL = "https://https://jsonplaceholder.typicode.com/"
		fun getRetrofitInstance() : Retrofit {
			return Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
				.build()
		}
	}
}

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
		val retService = RetrofitInstance 
			.getRetrofitInstance()
			.create(AlbumService::class.java)

		val responseLiveData : LiveData<Response<Albums>> = liveData {
			val response = retService.getAlbums()
			emit(response)
		}

		responseLiveData.observe(this, Observer {
			val albumsList = it.body()?.listIterator() // get elements one by one 
			if (albumsList != null) {
				while(albumsList.hasNext()) {
					val albumsItem = albumsList.next()
					Log.i("MyTAG", albumsItem.title)
					val result = " " + "Album Title : ${albumsItem.title}" + "\n" + " " + "Album Id : ${albumsItem.id" + "\n" + " " + "User Id: ${albumsItem.userId}" + "\n\n\n"
					bingding.textView.append(result)
				}
			}

		})
	}
}

