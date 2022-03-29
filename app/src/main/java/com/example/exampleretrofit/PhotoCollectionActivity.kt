package com.example.exampleretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.exampleretrofit.model.Photo
import com.example.exampleretrofit.recyclerview.PhotoGridRecyclerViewAdapter
import com.example.exampleretrofit.utils.Constants.TAG
import kotlinx.android.synthetic.main.activity_photo_collection.*

class PhotoCollectionActivity: AppCompatActivity() {

    // 데이터
    private var photoList = ArrayList<Photo>()

    // 어뎁터
    private lateinit var photoGridRecyclerViewAdapter: PhotoGridRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // layout과 연결
        setContentView(R.layout.activity_photo_collection)

        Log.d(TAG, "PhotoCollectionActivity - onCreate() called")

        val bundle = intent.getBundleExtra("array_bundle")

        val searchTerm = intent.getStringExtra("search_term")

        photoList = bundle?.getSerializable("photo_array_list") as ArrayList<Photo>

        top_app_bar.title = searchTerm

        Log.d(TAG, "PhotoCollectionActivity - onCreate() called / searchTerm : $searchTerm, photoList.count() : ${photoList.count()}")

        this.photoGridRecyclerViewAdapter = PhotoGridRecyclerViewAdapter()
        this.photoGridRecyclerViewAdapter.submitList(photoList)

        my_photo_recycler_view.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        my_photo_recycler_view.adapter = this.photoGridRecyclerViewAdapter
    }
}