package com.example.wordsdictionaryfinal.network

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.wordsdictionaryfinal.R

/**
 * When there is no Mars property data (data is null), hide the [RecyclerView], otherwise show it.
 */
//@BindingAdapter("listData")
//fun bindRecyclerView(recyclerView: RecyclerView, data: List<MarsProperty>?) {
//    val adapter = recyclerView.adapter as PhotoGridAdapter
//    adapter.submitList(data)
//}

/**
 * Uses the Glide library to load an image by URL into an [ImageView]
 */
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.ic_broken_image)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}
