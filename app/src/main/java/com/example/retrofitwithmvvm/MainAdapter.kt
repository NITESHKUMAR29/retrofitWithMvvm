package com.example.retrofitwithmvvm

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitwithmvvm.databinding.ItemMainBinding


class MainAdapter(private val context:Context,private val list: ArrayList<Product>):RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    class MainViewHolder(val binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view=LayoutInflater.from(parent.context)
        val binding:ItemMainBinding=DataBindingUtil.inflate(view,R.layout.item_main,parent,false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        with(holder.binding){
            val currentItem=list[position]

            Glide.with(context)
                .load(currentItem.thumbnail)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(mainImage)
            title.text=currentItem.title
            brand.text=currentItem.brand
            description.text=currentItem.description
            val adapter=ImageAdapter(context, currentItem.images as ArrayList<String>)
            imageRecycler.adapter=adapter
           // imageRecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)


        }
    }
}