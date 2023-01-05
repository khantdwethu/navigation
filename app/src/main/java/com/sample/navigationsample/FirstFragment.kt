package com.sample.navigationsample

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.navigationsample.adapter.NewsAdapter
import com.sample.navigationsample.data.ArticlesItem
import com.sample.navigationsample.databinding.FragmentFirstBinding
import com.sample.navigationsample.viewmodel.NewsViewModel


class FirstFragment : Fragment() {
//    lateinit var news : News
    lateinit var newsAdapter: NewsAdapter
    lateinit var _binding:FragmentFirstBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        this is for view model
        val newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        _binding = FragmentFirstBinding.inflate(layoutInflater,container,false)

        newsAdapter = NewsAdapter()

        newsViewModel.loadNews()



        newsViewModel.getNews().observe(
            viewLifecycleOwner, Observer{ news ->
            newsAdapter.updateArticleList(news.articles as List<ArticlesItem>)
            Log.d("NewsResponse>>>>",news.toString())
        })

        _binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
        }

        return _binding.root
    }


}