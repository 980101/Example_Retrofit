package com.example.exampleretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.exampleretrofit.retrofit.RetrofitManager
import com.example.exampleretrofit.utils.Constants.TAG
import com.example.exampleretrofit.utils.RESPONSE_STATE

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val searchTerm = intent.getStringExtra("keyword")

        // 검색 api 호출
        RetrofitManager.instance.searchPhotos(searchTerm = searchTerm, completion = {
                responseState, responseBody ->

                when(responseState) {
                    RESPONSE_STATE.OKAY -> {
                        Log.d(TAG, "api 호출 성공 : $responseBody")
                    }
                    RESPONSE_STATE.FAIL -> {
                        Toast.makeText(this, "api 호출 에러입니다.", Toast.LENGTH_SHORT).show()
                        Log.d(TAG, "api 호출 실패 : $responseBody")
                   }
                }
        })
    }
}