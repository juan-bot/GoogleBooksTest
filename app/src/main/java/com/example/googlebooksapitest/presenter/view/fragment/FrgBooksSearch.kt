package com.example.googlebooksapitest.presenter.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googlebooksapitest.databinding.FrgBooksSearchBinding
import com.example.googlebooksapitest.presenter.model.BookModel
import com.example.googlebooksapitest.presenter.view.BookListClickListener
import com.example.googlebooksapitest.presenter.view.adapter.AdpBookList
import com.example.googlebooksapitest.presenter.viewmodel.BookSearchViewModel

class FrgBooksSearch : Fragment(), BookListClickListener {
    private lateinit var binding: FrgBooksSearchBinding
    private val viewModel: BookSearchViewModel by viewModels()
    private lateinit var adapter: AdpBookList
    lateinit var listener: BookListClickListener
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgBooksSearchBinding.inflate(inflater, container, false)
        listener = this
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerBooks.layoutManager = LinearLayoutManager(requireContext())

        viewModel.adpBookList.observe(viewLifecycleOwner){
            adapter = it
            binding.recyclerBooks.adapter = it
        }

        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(query: String?): Boolean {
                println("Query: $query")
                if (query != null) {
                    viewModel.searchBooksFromWeb(query, listener)
                }
                return true
            }
        })
        binding.swchFav.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.search.setQuery("", false)
                binding.search.clearFocus()
                context?.let { viewModel.getFavoritesUsecase(it,listener) }
                viewModel.favorites.observe(viewLifecycleOwner){
                    if(!it){
                        Toast.makeText(context, "No Hay Favoritos", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {

            }
        }

    }
    override fun onBookListItemClick(view: View, user: BookModel) {
        val actionWithParametes = user.published?.let {
            user.description?.let { it1 ->
                FrgBooksSearchDirections.toFrgBookDetail(user.title,user.imgCover,user.author,
                    it, it1,user.linkToWeb,user.favorite)
            }
        }
        if (actionWithParametes != null) {
            findNavController().navigate(actionWithParametes)
        }
    }

}