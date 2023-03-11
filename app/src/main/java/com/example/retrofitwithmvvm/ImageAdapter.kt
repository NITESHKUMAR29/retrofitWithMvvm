package com.example.retrofitwithmvvm

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitwithmvvm.databinding.ItemImageBinding
import com.example.retrofitwithmvvm.databinding.ItemMainBinding


class ImageAdapter(private val context:Context, private val list: ArrayList<String>):RecyclerView.Adapter<ImageAdapter.MainViewHolder>() {


    class MainViewHolder(val binding: ItemImageBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view=LayoutInflater.from(parent.context)
        val binding:ItemImageBinding=DataBindingUtil.inflate(view,R.layout.item_image,parent,false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        with(holder.binding){
            val currentItem=list[position]

            Glide.with(context)
                .load(currentItem)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(image)

        }
    }
}