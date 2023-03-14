package com.shoppi.app.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImager(view: ImageView, imageurl: String){
    Glide.with(view)
        .load(imageurl)
        .into(view)
}