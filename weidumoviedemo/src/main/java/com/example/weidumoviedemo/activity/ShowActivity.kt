package com.example.weidumoviedemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.weidumoviedemo.R
import com.example.weidumoviedemo.adapter.ShowAdapter
import com.example.weidumoviedemo.api.WeiDuApi
import com.example.weidumoviedemo.bean.ReCommendListBean
import com.example.weidumoviedemo.mvp.Contract
import com.example.weidumoviedemo.mvp.MyPresenter
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity(),Contract.IView{

    private var myPresenter : MyPresenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        //方法
        initView()
        initData()
    }
    /**
     *操作视图
     */
    private fun initView(){
        //设置布局管理器
        rv.layoutManager=LinearLayoutManager(this)
        //初始化p层
        myPresenter = MyPresenter(this)
        //开始访问接口
        myPresenter!!.banner(WeiDuApi.BANNER_API)
        var map = HashMap<String,String>()
        map["plateId"]="1"
        map["page"]="1"
        map["count"]="10"
        myPresenter!!.recommendlist(WeiDuApi.RECOMMENDLIST_API,map)
    }
    /**
     * 操作数据
     */
    private fun initData() {

    }
    /**
     * 成功的回调
     */
    override fun success(any: Any) {
        if (any!=null){
            val bean = any as ReCommendListBean
            rv.adapter=ShowAdapter(R.layout.show_item,bean.result)
        }
    }
    /**
     * 轮播图
     */
    override fun banner(any: Any) {
        if (any!=null){

        }
    }
    /**
     * 失败的回调
     */
    override fun fail(string: String) {

    }

}
