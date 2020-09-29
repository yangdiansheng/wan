package com.yangdainsheng.mvvm

import android.os.Looper
import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.yangdainsheng.bean.User

class MyViewModel(private val state: SavedStateHandle) :ViewModel(){


    private val user : MutableLiveData<User> = MutableLiveData<User>()

    private var mUser:User? = null

    fun getUserData():MutableLiveData<User>{
        return user
    }

    fun saveUser(){
        state.set("name","liolilili")
        Log.i("yyy",  "save")
    }

    fun loadUser() {
        val namelive = state.getLiveData<String>("name")
        val name = state.get<String>("name")
        Log.i("yyy",  "namelive = " + namelive.value)
        Log.i("yyy",  "name = " + name)
        // Do an asynchronous operation to fetch users.
        Thread(Runnable {
            Thread.sleep(1000)
            mUser = User().also {
                it.name = "yangyangyang"
                it.age = 100
            }
            Log.i("yyy",  "mUser" +mUser.toString())
            user.postValue(mUser)
        }).start()
    }
}