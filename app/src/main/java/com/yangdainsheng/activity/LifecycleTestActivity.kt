package com.yangdainsheng.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yangdainsheng.mvp.LifeCycleMvp
import com.yangdainsheng.mvp.LifecycleEventMvp
import com.yangdainsheng.wan.R

class LifecycleTestActivity : AppCompatActivity(){

    companion object{
        fun start(activity: Activity){
            val intent = Intent()
            intent.setClass(activity, LifecycleTestActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_test)
        lifecycle.addObserver(LifeCycleMvp())
        lifecycle.addObserver(LifecycleEventMvp())
    }
}