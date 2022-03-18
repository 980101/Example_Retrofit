package com.example.exampleretrofit.utils

object Constants {
    const val TAG: String = "로그"
}

enum class SEARCH_TYPE {
    PHOTO,
    USER
}

enum class RESPONSE_STATE {
    OKAY,
    FAIL
}

object API {
    // 코틀린은 자료형을 유추하기 때문에 ': String'은 안써줘도 된다 !
    const val BASE_URL: String = "https://api.unsplash.com/"

    const val CLIENT_ID: String = "nseJB_rnq4Eqq66tFAgLcWsW7an59jcd6yItjFJqNy4"

    const val SEARCH_PHOTOS: String = "search/photos"
    const val SEARCH_USERS: String = "search/users"
}