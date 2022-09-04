package com.example.corrutina.main.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import com.example.corrutina.databinding.ItemMainListBinding


class MainAdapter: ListAdapter<String, MainAdapter.ViewHolder>(DiffUtilCallback) {

    private var items: List<String> = emptyList()

    class ViewHolder(view: ItemMainListBinding): RecyclerView.ViewHolder(view.root){
        val textView: TextView

        init {
            textView = view.textViewItemMain
        }
    }

    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): ViewHolder{
        val view = ItemMainListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(view)
    }


    fun setData(items: List<String>){
        this.items = items
        submitList(items)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int){
        holder.textView.text = getItem(position)
    }

    private object DiffUtilCallback:DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
                oldItem == newItem


        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
            oldItem == newItem

    }

}


