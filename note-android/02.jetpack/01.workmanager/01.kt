
// 출처: https://dongsik93.github.io/til/2020/05/15/til-jetpack-workmanager/
// workmanager

// 앱이 종료되거나 기기가 다시 시작되어도 실행 예정인 지연 가능한 비동기 작업을 쉽게 예약할 수 있게 해준다. 
// 안드로이드의 백그라운드 작업을 처리하는 방법 중 하나, Android Jetpack 아키텍쳐의 구성 요소 중 하나이다.
// 하나의 코드로 API Level 마다 비슷한 동작을 보장한다. 

// 주요 기능 

// 네트워크 가용성, 충전상태와 같은 작업의 제약 조건을 설정할 수 있다.
// 일회성 혹은 주기적인 비동기 작업을 예약할 수 있다.
// 예약된 작업 모니터링 및 관리
// 작업 체이닝
// 앱이나 기기가 다시 시작되는 경우에도 작업 실행을 보장한다.
// 잠자기 모드와 같은 절전 기능을 지원한다. 
// WorkManager는 앱이 종료되거나 기기가 다시 시작되는 경우에도 지연 가능하고 안정적으로 실행되어야 하는 작업을 대상으로 설계되어 있다. 
// 백엔드 서비스에 로그 또는 분석을 전송하는 작업
// 주기적으로 애플리케이션 데이터를 서버와 동기화 하는 작업 


// * WorkManager API의 주요 클래스는 WorkManager, Worker, WrokRequest, WorkState 이다. 

// Workmanager
//   처리해야 하는 작업을 자신의 큐에 넣고 관리한다. 
//   싱글톤으로 구현이 되어있기 때문에 getInstance()로 WorkManager의 인스턴스를 받아 사용한다. 

// Worker
//   추상 클래스이며, 처리해야 하는 백그라운드 작업의 처리 코드를 이 클래스를 상속받아 doWork() 메서드를 오버라이드 하여 작성하게 된다. 
//     doWork()
//       * 작업을 완료하고 결과에 따라 Worker 클래스 내에 정의된 enum인 Result의 값 중 하나를 리턴한다. 
//       * SUCCESS, FAILURE, RETRY의 3개 값이 있으며 리턴되는 이 값에 따라 WorkManager는 해당 작업을 마무리 할 것인지, 재시도 할 것인지, 실패로 정의하고 중단할 것인지를 결정하게 된다. 

// WorkRequest
//   * WorkManager를 통해 실제 요청하게 될 개별 작업이다.
//   * 처리해야 할 작업인 Work와 작업 반복 여부 및 작업 실행 조건, 제약 사항등 이 작업을 어떻게 처리할 것인지에 대한 정보가 담겨있다.
//   * 반복여부에 따라 onTimeWorkRequest, PeriodicWorkRequest로 나뉜다. 
//   * onTimeWorkRequest 
//     * 반복하지 않을 작업, 즉 한반만 실행할 작업의 요청을 나타내는 클래스 
//   * PeriodicWorkRequest
//     * 여러번 실행한 작업의 요청을 나타내는 클래스 

// WorkState
//   * WorkRequest의 id와 해당 WorkRequest의 현재 상태를 담는 클래스
//   * 이 WorkState의 상태정보를 이용해서 자신이 요청한 작업의 현재 상태를 파악할 수 있다.
//   * ENQUEUED, RUNNING, SUCCEEDED, FAILED, BLOCKED, CANCLED의 6대 상태를 가진다. 


import androidx.work.Worker 

class ExampleWorkder: Worker() {
	override fun doWork(): Result {
		// 처리해야할 작업에 관한 코드들
		return Result.suceess()
	}
}  

// * OneTimeWorkRequestBuilder 

// 코틀린에 정의된 인라인 함수 OneTimeWorkRequestBuilder
var workRequest = OneTimeWorkRequestBuilder<ExampleWork>().build()

// WorkManager 클래스의 getInstance() 메서드로 싱글턴 객체를 받아서 WorkManager의 작업 큐에 OneTimeWorkRequest 객체를 추가해준다. 

var workRequest = OneTimeWorkRequestBuilder<ExampleWork>().build()
val workManager = WorkManager.getInstance()
workManager?.enqueue(workRequest)

/* 반복 시간에 사용할 수 있는 가장 짧은 최소값은 15 */
val workReqeust = PeriodicWorkRequestBuilder<ExampleWorker>(15, TimeUnit.MINUTES).build()
val workManager = WorkManager.getInstance()
workManager?.enqueue(workRequest)


// 3. 연결된 작업
val workA = OneTimeWorkRequestBuilder<AWork>().build()
val workB = OneTimeWorkRequestBuilder<BWork>().build()

WorkManager.getInstance()?.apply {
	beginWith(workA).then(workB).enqueue()
}

// 4. 작업 처리상태 파악 
val workRequest = OneTimeWorkRequestBuilder<ExampleWorker>().build()
val workManager = WorkManager.getInstance()
workManager?.let {
	it.enqueue(workRequest)

	// WorkManager의 getStatusById()에 WorkRequest의 UUID 객체를 인자로 전달하면
	// 인자값으로 주어진 ID에 해당하는 작업을 추적할 수 있도록 LiveData 객체를 반환한다.

	val statusLiveData = it.getStatusById(workRequest.id)

	statusLiveData.observe(this, Observer { workState ->
        Log.d("exmaple", "state: ${workState?.state}")
    })
}

// 5. 작업간 정보 전달
val input = mapOf("question" to "answer")
// Data 클래스의 Builder를 사용해서 Data 객체를 생성한다. 
val inputData = Data.Builder().putAll(input).build()
val requestWork = OneTimeWorkRequestBuilder<ExampleWork>()
	.setInputData(inputData)
	.build()

val question = inputData.get("question"m "")