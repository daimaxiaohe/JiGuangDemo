package com.example.weidumoviedemo.util

import com.example.weidumoviedemo.api.WeiDuApi
import com.example.weidumoviedemo.api.WeiDuService
import com.example.weidumoviedemo.interceptor.NetInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author
 * @date 2019-04-08.
 * GitHub：
 * email：
 * description：
 */
class RetrofitUtil{
    private var retrofit: Retrofit? =null
    private constructor(){
        //拦截器
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        //okhttp
        val okhttp= OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .addNetworkInterceptor(NetInterceptor())
                .connectTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
               // .sslSocketFactory(SslFactory.getSSLSocketFactory(),MyX509TrustManager())
                .build()
        //retrofit
        retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okhttp)
                .baseUrl(WeiDuApi.BASE_API)
                .build()
    }
    //单例模式
    companion object {
        val instance: RetrofitUtil by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            RetrofitUtil()
        }
    }
    //初始化
    fun creatservice() : WeiDuService{
        return retrofit!!.create(WeiDuService::class.java)
    }
}