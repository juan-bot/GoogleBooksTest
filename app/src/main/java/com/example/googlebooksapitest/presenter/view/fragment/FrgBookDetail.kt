package com.example.googlebooksapitest.presenter.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.googlebooksapitest.databinding.FrgBookDetailBinding
import com.squareup.picasso.Picasso

class FrgBookDetail : Fragment() {
    private lateinit var binding: FrgBookDetailBinding
    private val argsFromSearch: FrgBookDetailArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgBookDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get().load(argsFromSearch.imgCover).into(binding.imgBook)
        binding.tvTitle.text = argsFromSearch.title
        binding.tvAuthor.text  = argsFromSearch.author
        binding.tvDescription.text  = argsFromSearch.description
    }
}