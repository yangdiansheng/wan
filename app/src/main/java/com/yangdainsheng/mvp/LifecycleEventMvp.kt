package com.yangdainsheng.mvp

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class LifecycleEventMvp :LifecycleEventObserver{

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.i("yyy", "LifecycleEventMvp $event")
    }

}
