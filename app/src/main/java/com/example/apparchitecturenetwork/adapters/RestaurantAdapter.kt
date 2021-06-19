package com.example.apparchitecturenetwork.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apparchitecturenetwork.databinding.RestaurantItemBinding
import com.example.apparchitecturenetwork.models.RestaurantModel

class RestaurantAdapter :
    androidx.recyclerview.widget.ListAdapter<RestaurantModel, RestaurantAdapter.RestaurantViewHolder>(RestaurantComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding =
            RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class RestaurantViewHolder(private val binding: RestaurantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: RestaurantModel) {
            binding.apply {
                Glide.with(itemView)
                    .load(restaurant.logo)
                    .into(imageViewLogo)

                textViewName.text = restaurant.name
                textViewType.text = restaurant.type
                textViewAddress.text = restaurant.address
            }
        }
    }
    //todo we need to compare between oldItem.id and newItem.id coz id already unq
    class RestaurantComparator : DiffUtil.ItemCallback<RestaurantModel>() {
        override fun areItemsTheSame(oldItem: RestaurantModel, newItem: RestaurantModel) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: RestaurantModel, newItem: RestaurantModel) =
            oldItem == newItem
    }
}