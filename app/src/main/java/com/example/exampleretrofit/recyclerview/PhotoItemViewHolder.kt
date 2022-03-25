package com.example.exampleretrofit.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exampleretrofit.App
import com.example.exampleretrofit.R
import com.example.exampleretrofit.model.Photo
import kotlinx.android.synthetic.main.layout_photo_item.view.*

class PhotoItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    // 뷰를 연결한다.
    private var photoCreatedText = itemView.created_at_text
    private var photoLikesCountText = itemView.likes_count_text
    private var photoImageView = itemView.photo_image

    // 데이터와 뷰를 연결한다.
    fun bindViewItem(photoItem: Photo) {
        photoCreatedText.text = photoItem.createAt
        photoLikesCountText.text = photoItem.likesCount.toString()

        Glide.with(App.instance)
            .load(photoItem.thumbnail)
            .placeholder(R.drawable.ic_baseline_insert_photo_24)
            .into(photoImageView)
    }
}