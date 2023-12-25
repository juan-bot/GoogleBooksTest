package com.example.googlebooksapitest.presenter.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.googlebooksapitest.R
import com.example.googlebooksapitest.presenter.model.BookModel
import com.squareup.picasso.Picasso

class AdpBookList(private val books: List<BookModel>): RecyclerView.Adapter<AdpBookList.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayout = when (viewType){
            0 -> R.layout.item_book
            else -> throw Exception("invalid type")
        }
        val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(books[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: BookModel){
            val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
            val tvAuthor: TextView = itemView.findViewById(R.id.tv_author)
            val imgCover: ImageView = itemView.findViewById(R.id.img_book)
            tvTitle.text = item.title
            tvAuthor.text = item.author
            Picasso.get().load(item.imgCover).into(imgCover)
        }
    }

}