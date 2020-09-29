package com.yangdainsheng.mvp

import android.util.Log
import androidx.lifecycle.*

class LifeCycleMvp :LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.i("yyy","oncreate")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        Log.i("yyy","onDestroy")
    }
}
