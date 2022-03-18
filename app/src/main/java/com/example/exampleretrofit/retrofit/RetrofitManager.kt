package com.example.exampleretrofit.retrofit

import android.util.Log
import com.example.exampleretrofit.utils.API.BASE_URL
import com.example.exampleretrofit.utils.Constants.TAG
import com.example.exampleretrofit.utils.RESPONSE_STATE
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {
    companion object {
        val instance = RetrofitManager()
    }

    // 레트로핏 인터페이스 가져오기
    private val iRetrofit: IRetrofit? = RetrofitClient.getClient(BASE_URL)?.create(IRetrofit::class.java)

    // 사진 검색 api 호출
    fun searchPhotos(searchTerm: String?, completion: (RESPONSE_STATE, String) -> Unit) {

        val term = searchTerm ?: ""

        val call: Call<JsonElement> = iRetrofit?.searchPhotos(searchTerm = term) ?: return

//        위와 같은 기능을 하는 코드
//        val term = searchTerm.let {
//            it
//        }?: ""

//        val call: Call<JsonElement> = iRetrofit?.searchPhotos(searchTerm = term).let {
//            it
//        }?: return

        call.enqueue(object: retrofit2.Callback<JsonElement> {

            // 응답에 성공했을 때 호출
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RetrofitManager - onResponse() called / response : ${response.body()}")

                // 값과 이벤트를 같이 넘겨준다.
                completion(RESPONSE_STATE.OKAY, response.body().toString())
            }

            // 응답에 실패했을 때 호출
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - onFailure() called / t: $t")

                completion(RESPONSE_STATE.FAIL, t.toString())
            }

        })
    }
}