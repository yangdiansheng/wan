package com.yangdainsheng.wan

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yangdainsheng.activity.EventTestActivity
import com.yangdainsheng.activity.FrescoTestActivity
import com.yangdainsheng.activity.GlideTestActivity
import com.yangdainsheng.activity.PicassoTestActivity
import com.yangdainsheng.event.EventPost
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {

    companion object{
        fun start(activity: Activity){
            val intent = Intent()
            intent.setClass(activity, MainActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)
        btn_start_event_test.setOnClickListener {
           EventTestActivity.start(this)
        }
        btn_start_glide_test.setOnClickListener {
            GlideTestActivity.start(this)
        }
        btn_start_picasso_test.setOnClickListener {
            PicassoTestActivity.start(this)
        }
        btn_start_fresico_test.setOnClickListener {
            FrescoTestActivity.start(this)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun onEventPost(event: EventPost){
        tv_main_content.text = event.content
    }
}
