package com.example.weidumoviedemo.bean
import com.google.gson.annotations.SerializedName



/**
 * @author
 * @date 2019-04-08.
 * GitHub：
 * email：
 * description：
 */
data class LoginBean(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: LoginResult,
    @SerializedName("status")
    val status: String
)

data class LoginResult(
    @SerializedName("headPic")
    val headPic: String,
    @SerializedName("nickName")
    val nickName: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("pwd")
    val pwd: String,
    @SerializedName("sessionId")
    val sessionId: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("userName")
    val userName: String,
    @SerializedName("whetherFaceId")
    val whetherFaceId: Int,
    @SerializedName("whetherVip")
    val whetherVip: Int
)