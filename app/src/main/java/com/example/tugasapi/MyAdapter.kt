package com.example.tugasapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class MyAdapter (val context: Context, var dataList: ArrayList<CEOModel.MangaModel>?): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val llmain = view.llMain
        val tvTittle = view.tvtittle
        val tvUrl = view.tvthumb
        val tvType = view.tvtype

        val tvUpdate = view.tvupdate
        val tvEnd = view.tvendpoint
        val tvChapter = view.tvchapter


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(
           (LayoutInflater.from(parent.context).inflate(
               R.layout.item_row , parent, false
           ))
       )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataList?.get(position)

        holder.tvTittle.text = item?.title.toString()
        holder.tvType.text = item?.type.toString()
        holder.tvUrl.text = item?.thumb.toString()
        holder.tvUpdate.text = item?.update.toString()
        holder.tvEnd.text = item?.endpoint.toString()
        holder.tvChapter.text = item?.chapter.toString()
        if (position % 2 == 0 ) {
            holder.llmain.setBackgroundColor(ContextCompat.getColor(context , R.color.brown))
        }else {
            holder.llmain.setBackgroundColor(ContextCompat.getColor(context , R.color.white))
        }
    }

    override fun getItemCount(): Int {
        return dataList!!.size
    }
}