package com.aman.basearchsetup.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aman.basearchsetup.R
import com.aman.basearchsetup.model.spotify.SpotifyMusicData

class SpotifyHomeAdapter() :
    ListAdapter<SpotifyMusicData, SpotifyHomeAdapter.SpotifyViewHolder>(diffUtil) {
    companion object {
        const val VIEW_TYPE_MIXES = 11
        const val VIEW_TYPE_RECENTLY_PLAYED = 22
        const val VIEW_TYPE_MOOD = 33
    }

    object diffUtil : DiffUtil.ItemCallback<SpotifyMusicData>() {
        override fun areItemsTheSame(
            oldItem: SpotifyMusicData,
            newItem: SpotifyMusicData
        ): Boolean {
            return oldItem.viewType == newItem.viewType
        }

        override fun areContentsTheSame(
            oldItem: SpotifyMusicData,
            newItem: SpotifyMusicData
        ): Boolean {
            return oldItem.equals(newItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val data = getItem(position).viewType
        return data ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpotifyViewHolder {
        val view = when (viewType) {
            VIEW_TYPE_MIXES -> LayoutInflater.from(parent.context)
                .inflate(R.layout.mixes_layout, parent, false)

            VIEW_TYPE_MOOD -> LayoutInflater.from(parent.context)
                .inflate(R.layout.mood_layout, parent, false)

            VIEW_TYPE_RECENTLY_PLAYED -> LayoutInflater.from(parent.context)
                .inflate(R.layout.recently_played_layout, parent, false)

            else -> LayoutInflater.from(parent.context)
                .inflate(R.layout.mixes_layout, parent, false)
        }
        return SpotifyViewHolder(view, viewType)
    }

    override fun onBindViewHolder(holder: SpotifyViewHolder, position: Int) {
        val homeData = getItem(position)
        when (homeData.viewType) {
            VIEW_TYPE_MIXES -> {
                holder.txtTitleMixes.text = homeData.title
                val adapter = MixesAdapter()
                adapter.submitList(homeData.items)
                holder.mixesRecView.layoutManager =
                    LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
                holder.mixesRecView.adapter = adapter
            }
            VIEW_TYPE_RECENTLY_PLAYED -> {
                holder.txtTitleRecentlyPlayed.text = homeData.title
                val adapter = RecentAdapter()
                adapter.submitList(homeData.items)
                holder.recentlyPlayedRecView.layoutManager =
                    LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
                holder.recentlyPlayedRecView.adapter = adapter
            }
            VIEW_TYPE_MOOD -> {
                holder.txtTitleMood.text = homeData.title
                val adapter = MoodAdapter()
                adapter.submitList(homeData.items)
                holder.moodRecView.layoutManager =
                    LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
                holder.moodRecView.adapter = adapter
            }
        }
    }

    class SpotifyViewHolder(view: View, viewType: Int) : RecyclerView.ViewHolder(view) {
        val moodRecView = view.findViewById<RecyclerView>(R.id.rv_mood)
        val txtTitleMood = view.findViewById<TextView>(R.id.txt_title_mood)
        val mixesRecView = view.findViewById<RecyclerView>(R.id.rv_mixes)
        val txtTitleMixes = view.findViewById<TextView>(R.id.txt_title_mixes)
        val recentlyPlayedRecView = view.findViewById<RecyclerView>(R.id.rv_recently_played)
        val txtTitleRecentlyPlayed = view.findViewById<TextView>(R.id.txt_title_recentlyplayed)
    }

}