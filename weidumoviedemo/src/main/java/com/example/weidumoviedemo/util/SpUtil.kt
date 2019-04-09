package com.example.weidumoviedemo.util

import android.content.Context
import android.content.SharedPreferences
import com.example.weidumoviedemo.app.MyApp

/**
 * @author
 * @date 2019-04-09.
 * GitHub：
 * email：
 * description：
 */
class SpUtil{
    private var sharedPreferences : SharedPreferences?=null
    private constructor(){
        sharedPreferences = MyApp.context.getSharedPreferences("user", Context.MODE_PRIVATE)
    }

    //单例模式
    companion object {
        val instance : SpUtil by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            SpUtil()
        }
    }

    //添加类型
    fun putString(name: String,value: String){
        sharedPreferences!!.edit().putString(name, value).commit()
    }
    //获取类型
    fun getString(name: String) : String{
        return sharedPreferences!!.getString(name,"")
    }
}