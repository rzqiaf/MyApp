package com.dicoding.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListBandAdapter (private val listBand: ArrayList<Band>) : RecyclerView.Adapter<ListBandAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_players, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listBand.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val  Band = listBand[position]
        holder.imgPhoto.setImageResource(Band.photo) // Menggunakan atribut 'photo' dari objek Band
        holder.tvName.text = Band.name
        holder.tvDescription.text = Band.description
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listBand[holder.adapterPosition]) }

    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)


    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Band)
    }
}