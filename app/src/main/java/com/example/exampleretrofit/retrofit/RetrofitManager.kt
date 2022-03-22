package com.example.exampleretrofit.retrofit

import android.util.Log
import com.example.exampleretrofit.model.Photo
import com.example.exampleretrofit.utils.API.BASE_URL
import com.example.exampleretrofit.utils.Constants.TAG
import com.example.exampleretrofit.utils.RESPONSE_STATE
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat

class RetrofitManager {
    companion object {
        val instance = RetrofitManager()
    }

    // 레트로핏 인터페이스 가져오기
    private val iRetrofit: IRetrofit? = RetrofitClient.getClient(BASE_URL)?.create(IRetrofit::class.java)

    // 사진 검색 api 호출
    fun searchPhotos(searchTerm: String?, completion: (RESPONSE_STATE, ArrayList<Photo>?) -> Unit) {

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

                when(response.code()) {
                    200 -> {

                        response.body()?.let {  // body에 값이 있다면 실행

                            var parsedPhotoDataArray = ArrayList<Photo>()
                            val body = it.asJsonObject
                            val results = body.getAsJsonArray("results")

                            val total = body.get("total").asInt

                            results.forEach{ resultItem ->
                                val resultItemObject = resultItem.asJsonObject

                                val user = resultItemObject.get("user").asJsonObject
                                val username: String = user.get("username").asString
                                val likesCount = resultItemObject.get("likes").asInt
                                val thumbnailLink = resultItemObject.get("urls").asJsonObject.get("thumb").asString
                                val createAt = resultItemObject.get("created_at").asString

                                // 날짜 데이터 수정
                                val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                                val formatter = SimpleDateFormat("yyyy년\nMM월 dd일")
                                val outputDateString = formatter.format(parser.parse(createAt))

//                                Log.d(TAG, "RetrofitManager - outputDateString : $outputDateString")

                                val photoItem = Photo(
                                    thumbnail = thumbnailLink,
                                    author = username,
                                    createAt = outputDateString,
                                    likesCount = likesCount
                                )

                                parsedPhotoDataArray.add(photoItem)
                            }
                            // 값과 이벤트를 같이 넘겨준다.
                            completion(RESPONSE_STATE.OKAY, parsedPhotoDataArray)
                        }
                    }
                }

            }

            // 응답에 실패했을 때 호출
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - onFailure() called / t: $t")

                completion(RESPONSE_STATE.FAIL, null)
            }

        })
    }
}