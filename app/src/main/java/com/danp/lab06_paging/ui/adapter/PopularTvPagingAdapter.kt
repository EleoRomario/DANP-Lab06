package com.danp.lab06_paging.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.danp.lab06_paging.data.local.entity.PopularTvDatabaseModel
import com.danp.lab06_paging.databinding.ItemPopularTvLayoutBinding
import com.danp.lab06_paging.utils.Constant.IMAGE_URL_START
import com.danp.lab06_paging.utils.loadImage
import javax.inject.Inject

class PopularTvPagingAdapter
@Inject
constructor() : PagingDataAdapter<PopularTvDatabaseModel, PopularTvPagingAdapter.PopularTvViewHolder>(DiffUtils) {

    class PopularTvViewHolder(private val binding: ItemPopularTvLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(popularTvDatabaseModel: PopularTvDatabaseModel){
            binding.apply {
                popularTvNameTextView.text = popularTvDatabaseModel.name
                popularTvLanguageTextView.text = popularTvDatabaseModel.original_language
                val imageUrl = IMAGE_URL_START + popularTvDatabaseModel.poster_path
                popularTvImageView.loadImage(imageUrl)
            }
        }
    }

    override fun onBindViewHolder(holder: PopularTvViewHolder, position: Int) {
        val popularTvItem = getItem(position)
        if(popularTvItem != null){
            holder.bind(popularTvItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularTvViewHolder {
        return PopularTvViewHolder(ItemPopularTvLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    object DiffUtils : DiffUtil.ItemCallback<PopularTvDatabaseModel>(){
        override fun areItemsTheSame(oldDatabaseModel: PopularTvDatabaseModel, newDatabaseModel: PopularTvDatabaseModel): Boolean {
            return oldDatabaseModel.popularTvId == newDatabaseModel.popularTvId
        }

        override fun areContentsTheSame(oldDatabaseModel: PopularTvDatabaseModel, newDatabaseModel: PopularTvDatabaseModel): Boolean {
            return oldDatabaseModel == newDatabaseModel
        }

    }
}