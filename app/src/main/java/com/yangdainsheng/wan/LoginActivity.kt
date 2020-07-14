package com.yangdainsheng.wan

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.yangdainsheng.UserManager
import com.yangdainsheng.ui.BaseActivity

class LoginActivity :BaseActivity(){

    companion object{
        fun start(activity: Activity){
            val intent = Intent()
            intent.setClass(activity, LoginActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        if(UserManager.isLogin()){

        }
    }
}