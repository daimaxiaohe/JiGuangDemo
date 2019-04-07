package com.example.jiguangdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import cn.jpush.android.api.JPushInterface
import android.util.Log
import org.greenrobot.eventbus.EventBus


/**
 * @author
 * @date 2019-04-07.
 * GitHub：
 * email：
 * description：
 */
class MyRecycler : BroadcastReceiver() {
    private val aa="hpp"
    override fun onReceive(context: Context, intent: Intent) {
        //获取intent中的值
        val banble = intent.extras
        //switch判断  根据不同的action  进行相应的操作
        when{
            //推送的recevidid
            JPushInterface.ACTION_REGISTRATION_ID==intent.action ->{
                val string = banble.getString(JPushInterface.EXTRA_REGISTRATION_ID)
                Log.i(aa,string)
            }
            //接收自定义消息
            JPushInterface.ACTION_MESSAGE_RECEIVED==intent.action->{
                var uri= banble.getString(JPushInterface.EXTRA_NOTIFICATION_URL)
                val string = banble.getString(JPushInterface.EXTRA_MESSAGE)
                Log.i(aa, "自定义$string$uri")
            }
            //接收推送下来的通知
            JPushInterface.ACTION_NOTIFICATION_RECEIVED ==intent.action->{
                var uri= banble.getString(JPushInterface.EXTRA_NOTIFICATION_URL)
                var string = banble.getString(JPushInterface.EXTRA_ALERT)
                Log.i(aa, "通知$string$uri")
            }
            //用户打开了通知
            JPushInterface.ACTION_NOTIFICATION_OPENED==intent.action->{
                //点击状态栏 将主页面textview  改成当前的文字
                Log.i(aa,"用户点击了通知")
                val string = banble.getString(JPushInterface.EXTRA_ALERT)
                if (string!=null&& "" != string){
                    EventBus.getDefault().postSticky(string)
                }
            }
        }
    }

}