package com.example.googlebooksapitest.presenter.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googlebooksapitest.R
import com.example.googlebooksapitest.databinding.FrgBookDetailBinding
import com.example.googlebooksapitest.databinding.FrgBooksSearchBinding
import com.example.googlebooksapitest.presenter.view.adapter.AdpBookList
import com.example.googlebooksapitest.presenter.viewmodel.BookSearchViewModel


class FrgBooksSearch : Fragment() {
    private lateinit var binding: FrgBooksSearchBinding
    private val viewModel: BookSearchViewModel by viewModels()
    private lateinit var adapter: AdpBookList
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgBooksSearchBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerBooks.layoutManager = LinearLayoutManager(requireContext())
        viewModel.searchBooksFromWeb("harry")
        viewModel.adpBookList.observe(viewLifecycleOwner){
            adapter = it
            binding.recyclerBooks.adapter = it
        }

    }

}