package com.danp.lab06_paging.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.danp.lab06_paging.R


fun View.setGone(){
    this.visibility  = View.GONE
}

fun View.setVisible(){
    this.visibility  = View.VISIBLE
}

fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this.context)
        .load(imageUrl)
        .error(R.drawable.ic_launcher_background)
        .into(this)
}