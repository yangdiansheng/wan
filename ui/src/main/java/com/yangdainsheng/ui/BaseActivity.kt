package com.yangdainsheng.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.yangdainsheng.ui.util.StatusBarUtil

open class BaseActivity:FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.statusBarLightMode(this)
    }
}