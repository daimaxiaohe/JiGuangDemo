package com.example.weidumoviedemo.app

import android.app.Application
import android.content.Context

/**
 * @author
 * @date 2019-04-08.
 * GitHub：
 * email：
 * description：
 */
class MyApp : Application(){
    companion object {
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context =this

    }
}