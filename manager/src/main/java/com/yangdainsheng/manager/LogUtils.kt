package com.yangdainsheng.manager

import android.util.Log
import java.util.concurrent.ExecutorService

object LogUtils {
    private var sExecutorService: ExecutorService? = null
    const val TAG = "yyy"

    fun setExecutor(executorService: ExecutorService?) {
        sExecutorService = executorService
    }

    fun i(msg: String?) {
        if(BuildConfig.DEBUG){
            Log.i(TAG, msg)
        }
    }
}