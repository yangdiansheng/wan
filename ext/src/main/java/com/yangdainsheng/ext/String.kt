package com.time.lib_ext

fun String.getHitPhone(): String {
    val builder: StringBuilder = StringBuilder()
    for (index in this.toCharArray().indices) {
        if (index < 3 || index > this.length - 5) {
            builder.append(this[index])
        } else {
            builder.append('*')
        }
    }
    return builder.toString()
}