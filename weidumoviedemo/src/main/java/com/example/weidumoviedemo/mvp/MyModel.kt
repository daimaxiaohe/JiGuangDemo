package com.example.weidumoviedemo.mvp

import android.annotation.SuppressLint
import com.example.weidumoviedemo.bean.LoginBean
import com.example.weidumoviedemo.util.ObserManger
import com.example.weidumoviedemo.util.ResponceCallBack
import com.example.weidumoviedemo.util.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import java.util.HashMap

/**
 * @author
 * @date 2019-04-08.
 * GitHub：
 * email：
 * description：
 */
class MyModel : Contract.IModel{

    /**登录的方法
     *
     */
    @SuppressLint("CheckResult")
    override fun login(string: String, map: HashMap<String, String>, callback: ResponceCallBack) {
        RetrofitUtil.instance.creatservice()
                .login(string,map)
                .compose(ObserManger<ResponseBody>())
                .subscribe({
                    callback!!.success(it.string())
                }, {
                    callback!!.fail(it.message!!)
                })
    }

    /**注册的方法
     *
     */
    @SuppressLint("CheckResult")
    override fun reg(string: String, map: HashMap<String, String>, callback: ResponceCallBack) {
        RetrofitUtil.instance.creatservice()
                .reg(string,map)
                .compose(ObserManger<ResponseBody>())
                .subscribe({
                    callback!!.success(it.string())
                }, {
                    callback!!.fail(it.message!!)
                })
    }

    /**展示的方法
     *
     */
    @SuppressLint("CheckResult")
    override fun recommendlist(string: String, map: HashMap<String, String>, callback: ResponceCallBack) {
        RetrofitUtil.instance.creatservice()
                .recommentlist(string,map)
                .compose(ObserManger<ResponseBody>())
                .subscribe({
                    callback!!.success(it.string())
                }, {
                    callback!!.fail(it.message!!)
                })
    }
    /**
     * 轮播图
     */
    @SuppressLint("CheckResult")
    override fun banner(string: String, callback: ResponceCallBack) {
        RetrofitUtil.instance.creatservice()
                .banner(string)
                .compose(ObserManger<ResponseBody>())
                .subscribe({
                    callback!!.success(it.string())
                }, {
                    callback!!.fail(it.message!!)
                })
    }
}