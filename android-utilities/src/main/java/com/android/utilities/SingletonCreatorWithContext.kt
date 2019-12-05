package com.android.utilities

import android.content.Context

/**
 * Created by Prasad Rao on 05-12-2019 17:27
 **/
open class SingletonCreatorWithContext<out T : Any>(val creator: (Context) -> T) {
    @Volatile
    private var instance: T? = null

    fun with(context: Context): T = instance ?: synchronized(this) {
        instance ?: creator(context).apply { instance = this }
    }
}