package com.yangdainsheng.activity

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.facebook.drawee.backends.pipeline.Fresco
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import com.yangdainsheng.event.EventPost
import com.yangdainsheng.wan.R
import kotlinx.android.synthetic.main.activity_event_test.*
import kotlinx.android.synthetic.main.activity_fresco_test.*
import kotlinx.android.synthetic.main.activity_glide_test.*
import org.greenrobot.eventbus.EventBus

class FrescoTestActivity : AppCompatActivity() {

    companion object {
        fun start(activity: Activity) {
            val intent = Intent()
            intent.setClass(activity, FrescoTestActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fresco_test)
        val url: String? = null
        val uri = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599025680303&di=7a203e54b198d6b31c975ab0d90698db&imgtype=0&src=http%3A%2F%2Fgss0.baidu.com%2F94o3dSag_xI4khGko9WTAnF6hhy%2Fzhidao%2Fpic%2Fitem%2F14ce36d3d539b6002ac5706de850352ac75cb7e4.jpg")
        my_image_view.setImageURI(uri);
    }
}
