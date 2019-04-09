package com.example.weidumoviedemo.mvp

import com.example.weidumoviedemo.bean.LoginBean
import com.example.weidumoviedemo.util.ResponceCallBack
import io.reactivex.internal.functions.ObjectHelper
import java.util.*

/**
 * @author
 * @date 2019-04-08.
 * GitHub：
 * email：
 * description：
 */
interface Contract{
    //抽象类
    abstract class IPresenter{
        abstract fun login(string: String,map: HashMap<String,String>)
        abstract fun reg(string: String,map: HashMap<String,String>)
        abstract fun recommendlist(string: String,map: HashMap<String,String>)
        abstract fun banner(string: String)
    }
    //view接口
    interface IView{
        fun success(any: Any)
        fun banner(any: Any)
        fun fail(string: String)
    }
    //model接口
    interface IModel{
        fun login(string: String,map: HashMap<String,String>,callback: ResponceCallBack)
        fun reg(string: String,map: HashMap<String,String>,callback: ResponceCallBack)
        fun recommendlist(string: String,map: HashMap<String,String>,callback: ResponceCallBack)
        fun banner(string: String,callback: ResponceCallBack)
    }
}