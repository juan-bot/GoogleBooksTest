package com.example.googlebooksapitest.presenter.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.googlebooksapitest.R
import com.example.googlebooksapitest.databinding.ActivityMainBinding
import com.example.googlebooksapitest.databinding.FrgBooksSearchBinding

class FrgBookDetail : Fragment() {
    private lateinit var binding: FrgBooksSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgBooksSearchBinding.inflate(inflater, container, false)
        return binding.root
    }
}