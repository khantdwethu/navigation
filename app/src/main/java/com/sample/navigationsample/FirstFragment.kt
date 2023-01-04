package com.sample.navigationsample

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.sample.navigationsample.api.NewSApiClient
import com.sample.navigationsample.data.News
import com.sample.navigationsample.viewmodel.NewsViewModel
import retrofit2.Call
import retrofit2.Response


class FirstFragment : Fragment() {
//    lateinit var news : News


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("LongLogTag")
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

//        this is for view model
        var newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        newsViewModel.loadNews()

//        var news = newsViewModel.getNews().value

        var titleText = view.findViewById<TextView>(R.id.title)
        var descText: TextView = view.findViewById(R.id.desc)

//        newsViewModel.getNews().observe(viewLifecycleOwner, { news ->
//            Log.d("ResponseViewModel->>>>>>>>>",news.articles.toString())
////            titleText.text = news?.articles?.get(0)?.title ?: "Empty"
////            descText.text = news?.articles?.get(0)?.description ?: "Empty"
//
//        })

        newsViewModel.getNews().observe(viewLifecycleOwner,{news->Log.d("ResponseViewModel->>>>>>>>>>",news.articles.toString())})



//
//        titleText.text = news?.articles?.get(0)?.title ?: "Empty"
//        descText.text = news?.articles?.get(0)?.description ?: "Empty"
        // Inflate the layout for this fragment
        return view
    }


}