package com.example.nasa_space_app.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nasa_space_app.R
import com.example.nasa_space_app.data.model.InfoData
import java.util.*

class RvInfoAdapter : ListAdapter<InfoData, RvInfoAdapter.ViewHolder>(InfoDataDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_list, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo_info = itemView.findViewById<ImageView>(R.id.photo_info)
        fun bind(item: InfoData) = with(itemView) {
            photo_info.setImageResource(item.photo)
        }
    }


}

class InfoDataDiffCallback : DiffUtil.ItemCallback<InfoData>() {
    override fun areItemsTheSame(oldItem: InfoData, newItem: InfoData): Boolean {
        //    example  return oldItem.nightId == newItem.nightId
// check with any value of the item
        return oldItem.photo==newItem.photo
    }

    override fun areContentsTheSame(oldItem: InfoData, newItem: InfoData): Boolean {
        return oldItem == newItem
    }
}