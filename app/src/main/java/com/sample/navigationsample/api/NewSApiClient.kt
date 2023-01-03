package com.sample.navigationsample.api

import com.sample.navigationsample.data.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NewSApiClient {

    private val BASE_URL = "https://newsapi.org/v2/"

    private  var newsApiInterface:NewsApiInterface

    init{
        //Retrofit builder function
        var retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        //Create API Call
        newsApiInterface = retrofit.create(NewsApiInterface::class.java)
    }


    fun getNewsWithQuery():Call<News>{
        return newsApiInterface.getEverything(
            "tesla",
            "eb0322f39ea247d3a02f5e35977367fc"
        );
    }
}