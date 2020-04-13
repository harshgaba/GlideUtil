package com.harshgaba.glidepoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var imageView:ImageView=findViewById<ImageView>(R.id.action_image)
        GlideUtil.clearCache(imageView.context)

        GlideUtil.loadImageWithThumbnailUrl("https://api.androidhive.info/images/glide/large/bvs.png",imageView,"https://api.androidhive.info/images/glide/large/deadpool.jpg")
    }
}
