package com.example.retrofitbasic01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import com.example.retrofitbasic01.databinding.ActivityMainBinding
import com.example.retrofitbasic01.models.Albums
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        val responseLiveData : LiveData<Response<Albums>> = liveData {
//
//        }

        binding.text = "Hello DataBinding to text"
    }
}
