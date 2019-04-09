package com.example.weidumoviedemo.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.weidumoviedemo.R
import com.example.weidumoviedemo.api.WeiDuApi
import com.example.weidumoviedemo.bean.LoginBean
import com.example.weidumoviedemo.mvp.Contract
import com.example.weidumoviedemo.mvp.MyPresenter
import com.example.weidumoviedemo.util.RsaCoder
import com.example.weidumoviedemo.util.SpUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener,Contract.IView{
    override fun banner(any: Any) {

    }

    //声明对象
    private var myPresenter:MyPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //初始化方法
        initView()
        initData()
    }
    /**
     * 操作视图
     */
    private fun initView() {
        //设置点击事件
        reg.setOnClickListener(this)
        login.setOnClickListener(this)
        //初始化p层
        myPresenter = MyPresenter(this)
    }
    /**
     * 操作视图
     */
    private fun initData() {

    }

    /**
     * 点击事件
     */
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.reg ->{
                val intent = intent
                intent.setClass(this, RegActivity::class.java)
                startActivity(intent)
            }
            R.id.login ->{
                val pwd = RsaCoder.encryptByPublicKey(ed_pwd.text.toString()!!)
                var map= HashMap<String,String>()
                map["phone"] = ed_phone.text.toString()
                map["pwd"] =pwd
                myPresenter!!.login(WeiDuApi.LOGIN_API,map)
            }
        }
    }
    /**
     * 成功回调函数
     */
    override fun success(any: Any) {
        if (any!=null){
            val loginBean = any as LoginBean
            Toast.makeText(this,loginBean.message,Toast.LENGTH_SHORT).show()
            if ("0000"==loginBean.status){
                SpUtil.instance.putString("userId",loginBean.result.userId)
                SpUtil.instance.putString("sessionId",loginBean.result.sessionId)
                startActivity(Intent(this,ShowActivity::class.java))
            }
        }
    }
    /**
     * 失败回调函数
     */
    override fun fail(string: String) {
        if (string!=null){
            Toast.makeText(this,string,Toast.LENGTH_SHORT).show()
            Log.i("hpp",string)
        }
    }

}
