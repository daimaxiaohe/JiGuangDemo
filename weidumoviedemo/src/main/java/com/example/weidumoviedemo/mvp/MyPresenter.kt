package com.example.weidumoviedemo.mvp

import com.example.weidumoviedemo.bean.BannerBean
import com.example.weidumoviedemo.bean.LoginBean
import com.example.weidumoviedemo.bean.ReCommendListBean
import com.example.weidumoviedemo.bean.RegBean
import com.example.weidumoviedemo.util.ResponceCallBack
import com.google.gson.Gson
import java.util.HashMap

/**
 * @author
 * @date 2019-04-08.
 * GitHub：
 * email：
 * description：
 */
class MyPresenter : Contract.IPresenter{
    //声明对象
    var view: Contract.IView
    private var model: MyModel
    //构造方法
    constructor(view: Contract.IView){
        this.view=view
        model=MyModel()
    }

    /**登录的方法
     *
     */
    override fun login(string: String, map: HashMap<String, String>) {
        model!!.login(string,map,object :ResponceCallBack{
            override fun success(string: String) {
                val loginBean = Gson().fromJson(string, LoginBean::class.java)
                view!!.success(loginBean)
            }

            override fun fail(string: String) {
                view!!.fail(string)
            }

        })
    }

    /**注册的方法
     *
     */
    override fun reg(string: String, map: HashMap<String, String>) {
        model!!.reg(string,map,object :ResponceCallBack{
            override fun success(string: String) {
                val regBean = Gson().fromJson(string, RegBean::class.java)
                view!!.success(regBean)
            }

            override fun fail(string: String) {
                view!!.fail(string)
            }

        })
    }

    /**列表展示
     *
     */
    override fun recommendlist(string: String, map: HashMap<String, String>) {
        model!!.recommendlist(string,map,object :ResponceCallBack{
            override fun success(string: String) {
                val remendbean = Gson().fromJson(string, ReCommendListBean::class.java)
                view!!.success(remendbean)
            }

            override fun fail(string: String) {
                view!!.fail(string)
            }

        })
    }
    /**
     * 轮播图
     */
    override fun banner(string: String) {
        model!!.banner(string,object :ResponceCallBack{
            override fun success(string: String) {
                val bannerBean = Gson().fromJson(string, BannerBean::class.java)
                view!!.banner(bannerBean)
            }

            override fun fail(string: String) {
                view!!.fail(string)
            }

        })
    }
}