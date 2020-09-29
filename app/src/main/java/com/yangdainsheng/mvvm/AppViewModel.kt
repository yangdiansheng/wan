package com.yangdainsheng.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.yangdainsheng.wan.App
import com.yangdainsheng.wan.AppContext

class AppViewModel :AndroidViewModel(AppContext.applicationContext as Application){
}