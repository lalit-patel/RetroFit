package com.patel.retrofit.Adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.patel.retrofit.Module.Post
import com.patel.retrofit.R
import kotlinx.android.synthetic.main.row_layout.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var myList = emptyList<Post>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.row_layout,
                parent,
                false
        ))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.userId_txt.text = myList[position].userId.toString()
        holder.itemView.id_txt.text = myList[position].id.toString()
        holder.itemView.title_txt.text =myList[position].title
        holder.itemView.body_txt.text =myList[position].body
    }

    fun setData(newList : List<Post>){
        myList = newList
        notifyDataSetChanged()
    }
}