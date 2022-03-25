package com.example.exampleretrofit.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleretrofit.App
import com.example.exampleretrofit.R
import com.example.exampleretrofit.model.Photo
import kotlin.collections.ArrayList

class PhotoGridRecyclerViewAdapter: RecyclerView.Adapter<PhotoItemViewHolder>() {

    private var photoList = ArrayList<Photo>()

    // 어뎁터와 레이아웃 연결
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoItemViewHolder {

        return PhotoItemViewHolder(LayoutInflater
            .from(App.instance)
            .inflate(R.layout.layout_photo_item, parent,false))
    }

    // 뷰가 묶였을 때 데이터를 뷰홀더에 넘겨준다.
    override fun onBindViewHolder(holder: PhotoItemViewHolder, position: Int) {
        holder.bindViewItem(this.photoList[position])
    }

    // 보여줄 목록의 개수
    override fun getItemCount(): Int {
        return this.photoList.size
    }

    // 외부에서 어뎁터에 데이터 배열을 넣어준다.
    fun submitList (photoList: ArrayList<Photo>) {
        this.photoList = photoList
    }
}