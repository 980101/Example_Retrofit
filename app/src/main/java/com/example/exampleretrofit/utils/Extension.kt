package com.example.exampleretrofit.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

// 문자열이 json 형태인지 체크
fun String?.isJsonObject(): Boolean {
    return this?.startsWith("{") == true && this.endsWith("}")

//    위 코드의 기능과 같다
//    if(this?.startsWith("{") == true && this.endsWith("}")) {
//        return true
//    } else {
//        return false
//    }
}

// 문자열이 json 배열인지 체크
fun String?.isJsonArray(): Boolean {
    return this?.startsWith("[") == true && this.endsWith("]")
}

// 에딧 텍스트에 대한 익스텐션
fun EditText.onMyTextChanged(completion: (Editable?) -> Unit){
    this.addTextChangedListener(object: TextWatcher {

        override fun afterTextChanged(editable: Editable?) {
            completion(editable)
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

    })
}