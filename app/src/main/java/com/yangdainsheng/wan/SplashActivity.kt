package com.yangdainsheng.wan

import android.os.Bundle
import com.yangdainsheng.account.UserManager
import com.yangdainsheng.login.LoginActivity
import com.yangdainsheng.ui.BaseActivity

class SplashActivity :BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        if(UserManager.isLogin()){
            MainActivity.start(this)
        }else {
            LoginActivity.start(this)
        }
        finish()
    }
}