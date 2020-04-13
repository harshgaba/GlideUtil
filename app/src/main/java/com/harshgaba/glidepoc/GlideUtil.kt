package com.harshgaba.glidepoc

import com.bumptech.glide.load.engine.DiskCacheStrategy
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import androidx.core.content.ContextCompat
import android.graphics.drawable.ColorDrawable
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade


object GlideUtil {

    private fun getRequestOptions(): RequestOptions {
        return RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
    }

    private fun getRequestOptionsWithPlaceholder(context: Context): RequestOptions {
        val cd = ColorDrawable(ContextCompat.getColor(context, R.color.colorPrimary))
        return getRequestOptions()
            .placeholder(cd)
            .fitCenter()
    }

    fun loadImage(url: String, imageView: ImageView) {
        val context = imageView.context
        Glide.with(context)
            .load(url)
            .apply(getRequestOptionsWithPlaceholder(context))
            .transition(withCrossFade())
            .into(imageView)
    }

    fun loadImageWithoutPlaceHolder(url: String, imageView: ImageView) {
        val context = imageView.context
        Glide.with(context)
            .load(url)
            .apply(getRequestOptions())
            .transition(withCrossFade())
            .into(imageView)
    }

    fun loadImageWithThumbnail(url: String, imageView: ImageView) {
        val context = imageView.context
        Glide.with(context)
            .load(url)
            .thumbnail(0.25f)
            .apply(getRequestOptionsWithPlaceholder(context))
            .transition(withCrossFade())
            .into(imageView)
    }

    fun loadImageWithThumbnailUrl(imageUrl: String, imageView: ImageView, thumbUrl: String) {
        val context = imageView.context
        Glide.with(context)
            .load(imageUrl)
            .thumbnail(Glide.with(context).load(thumbUrl))
            .apply(getRequestOptionsWithPlaceholder(context))
            .transition(withCrossFade())
            .into(imageView)
    }

    fun clearCache(context: Context) {
        // This method must be called on the main thread.
        Glide.get(context).clearMemory()
    }

}