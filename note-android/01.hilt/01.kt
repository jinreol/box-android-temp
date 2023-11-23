// https://underdog11.tistory.com/entry/Kotlin-%EB%A6%AC%EC%82%AC%EC%9D%B4%ED%81%B4%EB%9F%AC%EB%B7%B0%EC%97%90-%EB%B7%B0%EB%B0%94%EC%9D%B8%EB%94%A9-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0-%EC%BD%94%ED%8B%80%EB%A6%B0


class MainAcitivty: AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle) {
		private lateinit var adapter: EmployeeAdapter 

		override fun onCreate(savedInstanceState: Bundle?) {
			super.onCreate(savedInstanceState)

			adapter = EmployeeAdapter()
			rvEmployee.layoutManager = LinearLayoutManager(this)
			rvEmployee.adapter = adapter 

			mainViewModel.res.observe(this, Observer {
				when (it.status) {
					progree.visibllity = View.GONE
					rvEmployee.visibllity = View.VISIBLE

					if.data.let {

					}
				}
			})
		}

	}
}

observe it 뭐야? 
liveData는 뭐였지?

viewModelScope.launch // ViewModel 이 종료될 때 함수를 취소시킨다. 

android companion object => java static 

코틀린에서는 왜 static을 안 쓰게 되었을까?

코틀린 object 

class WhoAmI {
	private val name: String
	constructor(name: String) {
		this.name = name 
	}

	fun myNameIs() = "나의 이름을 ${name}입니다."
}


Retrofit도 모르겠다. 하하하
