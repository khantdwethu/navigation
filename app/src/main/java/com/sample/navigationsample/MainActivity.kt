package com.sample.navigationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sample.navigationsample.adapter.NewsAdapter
import com.sample.navigationsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var newsAdapter: NewsAdapter
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}