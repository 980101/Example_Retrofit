package com.example.exampleretrofit.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleretrofit.App
import com.example.exampleretrofit.R
import com.example.exampleretrofit.model.User

class UserLinearRecyclerViewAdapter: RecyclerView.Adapter<UserItemViewHolder>() {

    private var userList = ArrayList<User>()

    // 어뎁터와 레이아웃 연결
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {

        return UserItemViewHolder(LayoutInflater
            .from(App.instance)
            .inflate(R.layout.layout_user_item, parent, false))
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        holder.bindViewItem(this.userList[position])
    }

    override fun getItemCount(): Int {
        return this.userList.size
    }

    fun submitList(userList: ArrayList<User>) {
        this.userList = userList
    }
}