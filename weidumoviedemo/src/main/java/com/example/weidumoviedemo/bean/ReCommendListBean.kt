package com.example.weidumoviedemo.bean
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * @author
 * @date 2019-04-08.
 * GitHub：
 * email：
 * description：
 */
data class ReCommendListBean(
    val message: String,
    val result: List<ListResult>,
    val status: String
)

data class ListResult(
    val collection: Int,
    val id: Int,
    val releaseTime: Long,
    val share: Int,
    val source: String,
    val summary: String,
    val thumbnail: String,
    val title: String,
    val whetherAdvertising: Int,
    val whetherCollection: Int,
    val whetherPay: Int
)