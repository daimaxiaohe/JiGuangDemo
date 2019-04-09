package com.example.weidumoviedemo.bean
import com.google.gson.annotations.SerializedName


/**
 * @author
 * @date 2019-04-08.
 * GitHub：
 * email：
 * description：
 */
data class RegBean(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)