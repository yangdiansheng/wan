package com.yangdainsheng.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.yangdainsheng.mvp.LifeCycleMvp
import com.yangdainsheng.mvp.LifecycleEventMvp
import com.yangdainsheng.mvvm.MyViewModel
import com.yangdainsheng.wan.R

class ViewModelTestActivity : AppCompatActivity(){

    companion object{
        fun start(activity: Activity){
            val intent = Intent()
            intent.setClass(activity, ViewModelTestActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        model.saveUser()
    }

    private val model:MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel_test)
        model.getUserData().observe(this, Observer {
            Log.i("yyy", it.toString())
        })
        model.loadUser()
    }
}