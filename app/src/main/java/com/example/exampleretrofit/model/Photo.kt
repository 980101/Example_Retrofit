package com.example.exampleretrofit.model

import java.io.Serializable

// 직렬화가 가능하도록 설정
data class Photo(var thumbnail: String?,
                 var author: String?,
                 var createAt: String?,
                 var likesCount: Int?): Serializable {}