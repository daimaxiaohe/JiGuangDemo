package com.example.weidumoviedemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.weidumoviedemo.R
import com.example.weidumoviedemo.api.WeiDuApi
import com.example.weidumoviedemo.bean.RegBean
import com.example.weidumoviedemo.mvp.Contract
import com.example.weidumoviedemo.mvp.MyPresenter
import com.example.weidumoviedemo.util.RsaCoder
import kotlinx.android.synthetic.main.activity_reg.*

class RegActivity : AppCompatActivity(),View.OnClickListener,Contract.IView{
    override fun banner(any: Any) {

    }

    //声明对象
    private var myPresenter : MyPresenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        initView()
        initData()
    }
    /**
     * 操作视图
     */
    private fun initView() {
        //设置注册按钮点击事件
        reg.setOnClickListener(this)
        //初始化p层
        myPresenter= MyPresenter(this)
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
        val pwd = RsaCoder.encryptByPublicKey(ed_pwd.text.toString())
        var map= HashMap<String,String>()
        map["phone"] = ed_phone.text.toString()
        map["nickName"]=ed_name.text.toString()
        map["pwd"] =pwd
        myPresenter!!.reg(WeiDuApi.REG_API,map)
    }
    /**
     * 成功回调函数
     */
    override fun success(any: Any) {
        if (any!=null){
            val regBean = any as RegBean
            Toast.makeText(this,regBean.message, Toast.LENGTH_SHORT).show()
            if("0000"==regBean.status){
                
            }
        }
    }

    /**
     * 失败的回调函数
     */
    override fun fail(string: String) {
        if(string!=null){
            Toast.makeText(this,string, Toast.LENGTH_SHORT).show()
        }
    }
}
