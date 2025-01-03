package com.aman.basearchsetup.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aman.basearchsetup.databinding.MixesItemBinding
import com.aman.basearchsetup.model.spotify.Music
import com.aman.basearchsetup.utils.Util.loadImage

class MixesAdapter(): ListAdapter<Music, MixesAdapter.MixesViewHolder>(diffUtil) {
    companion object{
    val  diffUtil = object : DiffUtil.ItemCallback<Music>(){
        override fun areItemsTheSame(
            oldItem: Music,
            newItem: Music
        ): Boolean {
            return oldItem.musicName == newItem.musicName
        }

        override fun areContentsTheSame(
            oldItem: Music,
            newItem: Music
        ): Boolean {
            return oldItem.equals(newItem)
        }
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MixesViewHolder {
        val view = MixesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MixesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MixesViewHolder, position: Int) {
      val mixesData = getItem(position)
        holder.bind(mixesData)
    }

    inner class MixesViewHolder(view: MixesItemBinding ): RecyclerView.ViewHolder(view.root) {
        val mixImg = view.imgMixes
        fun bind(mixesData: Music){
            mixImg.loadImage(mixesData.imageBanner)
        }
    }
}