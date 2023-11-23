// 02.kt - Retrofit 
// https://velog.io/@24hyunji/Retrofit-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0
// gradle에 추가

implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

// 퍼미션 추가

<uses-permission android:name="android.permission.INTERNET" />

// 

data class Book ( 
    @SerializedName("itemId")val id:Long, //서버에서는 itemId라는 값을 가져와서,  app에선 id라는 값으로
    @SerializedName("title")val title:String,
    @SerializedName("description")val description:String,
    @SerializedName("coverSmallUrl")val coverSmallUrl:String

)

data class BestSellerDto (
    @SerializedName("title") val title: String, 
    @SerializedName("item") var books: List<Book>
)

data class SearchBookDto (
    @SerializedName("title") val title: String, 
    @SerializedName("item") var books: List<Book>
)

interface BookService {
    @GET("/api/search.api?output=json")
    fun getBookbyName(
        @Query("key") apiKey: String 
        @Query("query") keyword: String 
    ): Call<SearchBookDto>

    @GET("/api/bestSeller.api?output=json&categoryId=100")
    fun getBestSeller (
        @Query("key") apiKey: String 
    ): Call<BestSellerDto>
}


val retrofit = Retrofit.Builder()
    .baseUrl("https://book.interpack.com")
    .addConverterFactory(GsonConverterFactory.create()) // Json 데이터를 사용자가 정의한 Java 객채로 변환해주는 라이브러리 
    .build() // 레트로핏 구현체 완성!


val bookService = retrofit.create(BookService::class.java) // retrofit 객체 만듬

bookService.getBestSeller("38845BE9BD0EBEDF271A2D5BC770C5BEEBB2D38910F504545CE384C6692DA6D4")
    .enqueue(object: Callback<BestSellerDto>) {
        override fun onFailure(call: Call<BestSellerDto>, t: Throwable) {
            Log.d(TAG, t.toString())
        }

        override fun onResponse(call: Call<BestSellerDto>, response: Response<BestSellerDto>) {
            if (response.isSuccessful.not()) {
                return 
            }

            respone.body()?.let {
                Log.d(TAG, it.toString())
            }

            it.books.forEach { book -> 
                Log.d(TAG, book.toString())
            }
        }
    }

