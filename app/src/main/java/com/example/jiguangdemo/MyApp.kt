package com.example.jiguangdemo

import android.app.Application
import android.util.Log
import cn.jpush.android.api.JPushInterface
import cn.jpush.android.data.JPushLocalNotification

/**
 * @author
 * @date 2019-04-07.
 * GitHub：
 * email：
 * description：
 */
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)
        //设置别名
        JPushInterface.setAlias(this,1,"aa")
        val registrationID = JPushInterface.getRegistrationID(this)
        Log.i("hpp",registrationID)
        //设置标记
        //JPushInterface.setTags()
    }
}