package com.sample.navigationsample.api

import com.sample.navigationsample.data.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.security.Key

interface NewsApiInterface {
    @GET("everything")
    fun getEverything(
    @Query("q") query: String,
    @Query("apiKey") apiKey: String
    ): Call<News>
}