package com.example.exampleretrofit.retrofit

import com.example.exampleretrofit.utils.API
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofit {

    // https://www.unsplash.com/search/photos/?query="매개변수"
    @GET(API.SEARCH_PHOTOS)  // 추가되는 url( = url 엔드포인트 )을 매개변수로 넣어준다.
    fun searchPhotos(@Query("query") searchTerm: String,
                     @Query("per_page") size: String): Call<JsonElement>

    @GET(API.SEARCH_USERS)
    fun searchUsers(@Query("query") searchTerm: String): Call<JsonElement>
}