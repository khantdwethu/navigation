package com.sample.navigationsample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.navigationsample.data.ArticlesItem
import com.sample.navigationsample.databinding.SingleItemBinding


class NewsAdapter:RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

   var articleList : List<ArticlesItem> = ArrayList();

   inner class NewsViewHolder(val binding: SingleItemBinding): RecyclerView.ViewHolder(binding.root)


   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
     val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false);
      return  NewsViewHolder(binding)
   }


   override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
     holder.binding.title1.text= articleList.get(position).title
      holder.binding.desc1.text = articleList.get(position).description
      }

   override fun getItemCount(): Int = articleList.size

   fun updateArticleList(articleList:List<ArticlesItem>){
      this.articleList = articleList;
      notifyDataSetChanged()
   }
}