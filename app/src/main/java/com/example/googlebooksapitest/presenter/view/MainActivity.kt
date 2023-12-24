package com.example.googlebooksapitest.presenter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.googlebooksapitest.R
import com.example.googlebooksapitest.databinding.ActivityMainBinding
import com.example.googlebooksapitest.presenter.viewmodel.ActivityMainVM

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}