package com.yangdainsheng.media

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.view.SurfaceHolder
import androidx.annotation.RequiresApi
import java.io.IOException

object MediaCreate {

    /**
     * holder 控制器 Surface的控制器，用来操作Surface，处理他在Canvas上作画的效果和动画，控制表面，大小，像素
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun create(context: Context,
               uri: Uri,
               holder: SurfaceHolder?,
               audioAttributes: AudioAttributes?,
               audioSessionId:Int):MediaPlayer?{
        try {
            val mp = MediaPlayer()
            val aa = audioAttributes ?: AudioAttributes.Builder().build()
            mp.setAudioAttributes(aa)//设置音频属性
            mp.audioSessionId = audioSessionId
            //设置声音回话id，视频，音频分开渲染
            mp.setDataSource(context,uri)//从这里开始设置setDateSource
            mp.setDisplay(holder)
            mp.prepare()//开始准备
            return mp
        }catch (e :IOException){}
        return null
    }
}