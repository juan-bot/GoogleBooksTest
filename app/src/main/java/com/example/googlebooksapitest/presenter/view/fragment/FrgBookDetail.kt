package com.example.googlebooksapitest.presenter.view.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.googlebooksapitest.R
import com.example.googlebooksapitest.databinding.FrgBookDetailBinding
import com.example.googlebooksapitest.presenter.model.BookModel
import com.example.googlebooksapitest.presenter.viewmodel.BookDetalViewModel
import com.squareup.picasso.Picasso


class FrgBookDetail : Fragment() {
    private lateinit var binding: FrgBookDetailBinding
    private val argsFromSearch: FrgBookDetailArgs by navArgs()
    private val viewModel: BookDetalViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgBookDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(argsFromSearch.imgCover=="")
            binding.imgBook.setImageResource(R.drawable.no_available)
        else
            Picasso.get().load(argsFromSearch.imgCover).into(binding.imgBook)

        binding.tvTitle.text = argsFromSearch.title
        binding.tvAuthor.text  = argsFromSearch.author
        binding.tvDescription.text  = argsFromSearch.description
        binding.btnWebsite.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(argsFromSearch.linkToWeb))
            startActivity(browserIntent)
        }
        binding.btnFavorite.setOnClickListener{
            val book = BookModel(
                argsFromSearch.title,
                argsFromSearch.imgCover,
                argsFromSearch.author,
                argsFromSearch.published,
                argsFromSearch.description,
                argsFromSearch.linkToWeb,
                true
            )

            context?.let { viewModel.insertBook(it, book) }
            Toast.makeText(context, "Libro añadido a favoritos!", Toast.LENGTH_SHORT).show()
        }
    }
}