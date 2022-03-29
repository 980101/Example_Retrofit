package com.example.exampleretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.exampleretrofit.model.User
import com.example.exampleretrofit.utils.Constants.TAG
import kotlinx.android.synthetic.main.activity_user_collection.*

class UserCollectionActivity: AppCompatActivity() {

    // 데이터
    private var userList = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_collection)

        Log.d(TAG, "UserCollectionActivity - onCreate() called")

        val bundle = intent.getBundleExtra("array_bundle")
        val searchTerm = intent.getStringExtra("search_term")

        userList = bundle?.getSerializable("user_array_list") as ArrayList<User>

        top_app_bar.title = searchTerm

        Log.d(TAG, "UserCollectionActivity - onCreate() called / searchTerm : $searchTerm, photoList.count() : ${userList.count()}")
    }
}