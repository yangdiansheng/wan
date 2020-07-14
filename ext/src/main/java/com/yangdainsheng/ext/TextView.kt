package com.time.lib_ext

import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import java.util.regex.Pattern

fun TextView.highStr(str: String, needHighStr: String, highColor: Int): Spanned {
    val s = SpannableString(str)
    val p = Pattern.compile(needHighStr)
    val m = p.matcher(s)

    while (m.find()) {
        val start = m.start()
        val end = m.end()
        s.setSpan(ForegroundColorSpan(highColor), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
    return s
}
