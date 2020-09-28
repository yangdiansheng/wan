package com.yangdainsheng.wan

import android.app.Application
import android.content.ContextWrapper
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.multidex.MultiDexApplication
import com.facebook.drawee.backends.pipeline.Fresco
import com.yangdainsheng.event.MyEventBusIndex
import com.yangdainsheng.manager.ProcessManager
import org.greenrobot.eventbus.EventBus


private lateinit var INSTANCE: Application

object AppContext : ContextWrapper(INSTANCE)

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initAppListener()
        EventBus.builder().addIndex(MyEventBusIndex()).build()
        Fresco.initialize(this)

    }

    private fun initAppListener(){
        ProcessLifecycleOwner.get().lifecycle.addObserver(ProcessManager.ProcessLifecycler())
    }
}

