package com.example.weidumoviedemo.api

import com.example.weidumoviedemo.bean.BannerBean
import com.example.weidumoviedemo.bean.LoginBean
import com.example.weidumoviedemo.bean.ReCommendListBean
import com.example.weidumoviedemo.bean.RegBean
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

/**
 * @author
 * @date 2019-04-08.
 * GitHub：
 * email：
 * description：
 */
interface WeiDuService{
    //登录
    @POST
    @FormUrlEncoded
    fun login(@Url string: String,@FieldMap map: HashMap<String,String>) : Observable<ResponseBody>
    //注册
    @POST
    @FormUrlEncoded
    fun reg(@Url string: String,@FieldMap map: HashMap<String,String>) : Observable<ResponseBody>
    //咨询列表展示
    @GET
    fun recommentlist(@Url string: String,@QueryMap map: HashMap<String,String>) : Observable<ResponseBody>
    //轮播图
    @GET
    fun banner(@Url string: String) : Observable<ResponseBody>
}