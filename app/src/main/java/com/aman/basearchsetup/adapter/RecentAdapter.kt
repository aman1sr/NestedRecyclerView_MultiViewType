package com.aman.basearchsetup.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aman.basearchsetup.databinding.MixesItemBinding
import com.aman.basearchsetup.databinding.RecentlyPlayedItemBinding
import com.aman.basearchsetup.model.spotify.Music
import com.aman.basearchsetup.utils.Util.loadImage

class RecentAdapter(): ListAdapter<Music, RecentAdapter.RecentViewHolder>(diffUtil) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentViewHolder {
        val view = RecentlyPlayedItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RecentViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecentViewHolder, position: Int) {
        val mixesData = getItem(position)
        holder.bind(mixesData)
    }

    inner class RecentViewHolder(view: RecentlyPlayedItemBinding): RecyclerView.ViewHolder(view.root) {
        val mixImg = view.imgRecent
        val musicName = view.txtRecent
        fun bind(mixesData: Music){
            mixImg.loadImage(mixesData.imageBanner)
            musicName.text = mixesData.musicName
        }
    }
}