package com.sample.navigationsample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.sample.navigationsample.api.NewSApiClient
import com.sample.navigationsample.data.News
import retrofit2.Call
import retrofit2.Response


class FirstFragment : Fragment() {
//    lateinit var news : News


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val nextButton: Button = view.findViewById(R.id.btnNext);

        nextButton.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
            findNavController().navigate(action);
        }

        var titleText = view.findViewById<TextView>(R.id.title);
        var descText: TextView = view.findViewById(R.id.desc);

//        var news = loadNews()

        val newsApiClient = NewSApiClient();

        val apiCall = newsApiClient.getNewsWithQuery()

        apiCall.enqueue(object : retrofit2.Callback<News> {

            override fun onResponse(call: Call<News>, response: Response<News>) {
                titleText.text = response.body()!!.articles?.get(0)?.title ?: "Empty Title"

                descText.text = response.body()!!.articles?.get(0)?.description ?: "Empty Title"
//                Log.d("Response:>>>>>>",response.body().toString());
                if (response.isSuccessful()) {
                    Log.d("Resspnesss======>>>>", Gson().toJson(response.body()))
                    Log.d("-------->>>>>>>>>", "suc")
                } else {
                    Log.d("-----------<<<<<<<<<<<", "Fail")

                }

            }


            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e("Response:>>>>>>", t.toString());
            }

        })

//        titleText.text = news.articles?.get(0)?.title ?: "Empty";
//        descText.text = news.articles?.get(0)?.description ?: "Empty";
        // Inflate the layout for this fragment
        return view
    }


    //    this is for api  call
    fun loadNews(): News {
        var news = News();
        val newsApiClient = NewSApiClient();

        val apiCall = newsApiClient.getNewsWithQuery()

        apiCall.enqueue(object : retrofit2.Callback<News> {

            override fun onResponse(call: Call<News>, response: Response<News>) {
                news = response.body()!!
//                Log.d("Response:>>>>>>",response.body().toString());
                if (response.isSuccessful()) {
                    Log.d("Resspnesss======>>>>", Gson().toJson(response.body()))
                    Log.d("-------->>>>>>>>>", "suc")
                } else {
                    Log.d("-----------<<<<<<<<<<<", "Fail")

                }

            }


            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e("Response:>>>>>>", t.toString());
            }

        })

        return news;
    }


}