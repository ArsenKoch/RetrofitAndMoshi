package ua.cn.stu.http.sources.base

import com.squareup.moshi.Moshi
import retrofit2.Retrofit


class RetrofitConfig(
    val retrofit: Retrofit,
    val moshi: Moshi,
)