package com.yangdainsheng.wan

import android.app.Application
import android.content.ContextWrapper
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.multidex.MultiDexApplication
import com.yangdainsheng.manager.ProcessManager


private lateinit var INSTANCE: Application

object AppContext : ContextWrapper(INSTANCE)

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initAppListener()

    }

    private fun initAppListener(){
        ProcessLifecycleOwner.get().lifecycle.addObserver(ProcessManager.ProcessLifecycler())
    }
}

