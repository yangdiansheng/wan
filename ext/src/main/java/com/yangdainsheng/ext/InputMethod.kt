package com.time.lib_ext

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import org.jetbrains.anko.inputMethodManager

fun Context.toggleSofetInput(){
    inputMethodManager.toggleSoftInput(0,InputMethodManager.HIDE_NOT_ALWAYS)
}

fun View.showSoftInput():Boolean {
    return context.inputMethodManager.showSoftInput(this,InputMethodManager.SHOW_FORCED)
}

fun Activity.showSoftInput():Boolean{
    return currentFocus?.showSoftInput()?: false
}

fun View.hideSoftInput():Boolean{
    return context.inputMethodManager.hideSoftInputFromWindow(windowToken,0)
}

fun Activity.hideSoftInput():Boolean {
    return currentFocus?.hideSoftInput()?:false
}

fun Context.isActive():Boolean{
    return inputMethodManager.isActive
}

var mOnGlobalLayoutListener: ViewTreeObserver.OnGlobalLayoutListener? = null

internal var isVisiableForLast = false

fun Activity.addOnSoftKeyBoardVisibleListener(listener:IKeyBoardVisibleListener){
    val decorView = this.window.decorView
    mOnGlobalLayoutListener = ViewTreeObserver.OnGlobalLayoutListener {
        val rect = Rect()
        decorView.getWindowVisibleDisplayFrame(rect)
        //计算出可见屏幕的高度
        val displayHight = rect.bottom - rect.top
        //获得屏幕整体的高度
        val hight = decorView.height
        //获得键盘高度
        val keyboardHeight = hight - displayHight
        val visible = displayHight.toDouble() / hight < 0.8
        if (visible != isVisiableForLast) {
            listener.onSoftKeyBoardVisible(visible, keyboardHeight)
        }
        isVisiableForLast = visible
    }
    decorView.viewTreeObserver.addOnGlobalLayoutListener(mOnGlobalLayoutListener)
}

fun Activity.removeSoftKeyBoardVisibleListener() {
    val decorView = this.window.decorView
    decorView.viewTreeObserver.removeOnGlobalLayoutListener(mOnGlobalLayoutListener)
}

interface IKeyBoardVisibleListener {
    fun onSoftKeyBoardVisible(visible: Boolean, keyboardHeight: Int)
}