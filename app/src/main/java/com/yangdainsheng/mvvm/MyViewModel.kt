package com.yangdainsheng.mvvm

import android.os.Looper
import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yangdainsheng.bean.User

class MyViewModel :ViewModel(){

    private val user : MutableLiveData<User> = MutableLiveData<User>()

    private var mUser:User? = null

    fun getUserData():MutableLiveData<User>{
        return user
    }

    fun loadUser() {
        // Do an asynchronous operation to fetch users.
        Thread(Runnable {
            Thread.sleep(1000)
            mUser = User().also {
                it.name = "yangyangyang"
                it.age = 100
            }
            Log.i("yyy",  "mUser" +mUser.toString())
            android.os.Handler(Looper.getMainLooper()).post {
                user.value = mUser
            }
        }).start()
    }
}