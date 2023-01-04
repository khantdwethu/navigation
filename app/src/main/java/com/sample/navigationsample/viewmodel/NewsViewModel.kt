package com.sample.navigationsample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.navigationsample.api.NewSApiClient
import com.sample.navigationsample.data.News
import okhttp3.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel: ViewModel() {
    private var news: MutableLiveData<News> = MutableLiveData()

    fun getNews():LiveData<News> = news

    fun loadNews() {
        var newSApiClient = NewSApiClient()

        val apiCall = newSApiClient.getNewsWithQuery()

        apiCall.enqueue(
            object : Callback<News> {

                override fun onResponse(call: retrofit2.Call<News>, response: Response<News>) {
                    news.value = response.body()
                }

                override fun onFailure(call: retrofit2.Call<News>, t: Throwable) {

                }

            }
        )
    }
}