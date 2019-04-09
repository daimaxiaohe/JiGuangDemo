package com.example.weidumoviedemo.interceptor

import com.example.weidumoviedemo.util.SpUtil
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author
 * @date 2019-04-09.
 * GitHub：
 * email：
 * description：
 */
class NetInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
                .addHeader("userId", SpUtil.instance.getString("userId"))
                .addHeader("sessionId", SpUtil.instance.getString("sessionId"))
                .build()
        //响应头
        return chain.proceed(request)
    }

}