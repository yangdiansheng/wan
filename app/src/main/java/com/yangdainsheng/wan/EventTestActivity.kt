package com.yangdainsheng.wan

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yangdainsheng.event.EventPost
import kotlinx.android.synthetic.main.activity_event_test.*
import org.greenrobot.eventbus.EventBus

class EventTestActivity : AppCompatActivity() {

    companion object{
        fun start(activity: Activity){
            val intent = Intent()
            intent.setClass(activity, EventTestActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_test)
        tv_event_post.setOnClickListener {
            EventBus.getDefault().post(EventPost("from event Test"))
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
