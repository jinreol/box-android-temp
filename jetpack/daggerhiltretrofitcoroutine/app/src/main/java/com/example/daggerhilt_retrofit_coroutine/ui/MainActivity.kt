package com.example.daggerhilt_retrofit_coroutine.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerhilt_retrofit_coroutine.databinding.ActivityMainBinding
import com.example.daggerhilt_retrofit_coroutine.other.Status
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = EmployeeAdapter()
        binding.rvEmployees.layoutManager = LinearLayoutManager(this)
        binding.rvEmployees.adapter = adapter

        mainViewModel.res.observe(this, Observer {
            when(it.status) {
                Status.SUCCESS -> {
                    Log.d("cowcow", "MainActivity Status.Success")
                    binding.progress.visibility = View.GONE
                    binding.rvEmployees.visibility = View.VISIBLE
                    it.data.let { res ->
                        if (res?.status == "success") {
                            res.data?.let { it1 -> adapter.submitList((it1))}
                        } else {
                            Snackbar.make(binding.root, "Status = false",Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
                Status.LOADING -> {
                    Log.d("cowcow", "MainActivity Status.Loading")
                    binding.progress.visibility = View.VISIBLE
                    binding.rvEmployees.visibility = View.GONE
                }
                Status.ERROR -> {
                    Log.d("cowcow", "MainActivity Status.ERROR")
                    binding.progress.visibility = View.GONE
                    binding.rvEmployees.visibility = View.VISIBLE
                    Snackbar.make(binding.root, "Something went wrong",Snackbar.LENGTH_SHORT).show()

                }
            }
        })
    }
}