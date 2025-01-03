package com.aman.basearchsetup.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aman.basearchsetup.databinding.MoodBannerItemBinding
import com.aman.basearchsetup.databinding.RecentlyPlayedItemBinding
import com.aman.basearchsetup.model.spotify.Music
import com.aman.basearchsetup.utils.Util.loadImage

class MoodAdapter(): ListAdapter<Music, MoodAdapter.MoodViewHolder>(diffUtil) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        val view = MoodBannerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        val mixesData = getItem(position)
        holder.bind(mixesData)
    }

    inner class MoodViewHolder(view: MoodBannerItemBinding): RecyclerView.ViewHolder(view.root) {
        val mixImg = view.imgMood
        fun bind(mixesData: Music){
            mixImg.loadImage(mixesData.imageBanner)
        }
    }
}