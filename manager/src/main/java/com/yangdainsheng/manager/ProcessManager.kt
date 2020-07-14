package com.yangdainsheng.manager

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

object ProcessManager{

    var isBackGround = false

    class ProcessLifecycler : LifecycleObserver{
        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        private fun onAppBackground() {
            isBackGround = false
            // 应用进入后台
            LogUtils.i("LifecycleChecker onAppBackground ON_STOP");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        private fun onAppForeground() {
            isBackGround = true
            // 应用进入前台
            LogUtils.i("LifecycleChecker onAppForeground ON_START");
        }
    }
}