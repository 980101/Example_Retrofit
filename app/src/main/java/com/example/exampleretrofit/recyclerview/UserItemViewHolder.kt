package com.example.exampleretrofit.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.exampleretrofit.App
import com.example.exampleretrofit.R
import com.example.exampleretrofit.model.User
import kotlinx.android.synthetic.main.layout_user_item.view.*

class UserItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private var userNameText = itemView.user_name_text
    private var userNicknameText = itemView.nickname_text
    private var userImageView = itemView.user_image

    fun bindViewItem(userItem: User) {
        userNameText.text = userItem.name
        userNicknameText.text = userItem.nickName

        Glide.with(App.instance)
            .load(userItem.profile)
            .placeholder(R.drawable.ic_baseline_insert_photo_24)
            .into(userImageView)
    }
}