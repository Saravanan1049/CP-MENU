package com.example.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter(val data:List<Recycle>,val click:ContextClick):RecyclerView.Adapter<RecycleAdapter.RecyclerViewModel>() {
    class RecyclerViewModel(itemView:View):RecyclerView.ViewHolder(itemView) {
        val textName = itemView.findViewById<TextView>(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewModel {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.recycle,parent,false)
        return RecyclerViewModel(layout)
    }

    override fun onBindViewHolder(holder: RecyclerViewModel, position: Int) {
        holder.textName.text = data[position].name
        holder.textName.setOnClickListener {
            click.onClick(it)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}