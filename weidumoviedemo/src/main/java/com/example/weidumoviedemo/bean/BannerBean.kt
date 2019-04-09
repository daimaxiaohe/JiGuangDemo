package com.example.weidumoviedemo.bean
import com.google.gson.annotations.SerializedName


/**
 * @author
 * @date 2019-04-09.
 * GitHub：
 * email：
 * description：
 */
data class BannerBean(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: List<Result>,
    @SerializedName("status")
    val status: String
)

data class Result(
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("jumpUrl")
    val jumpUrl: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("title")
    val title: String
)