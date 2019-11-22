package com.sharaga.yourcityevents_android.model

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonClass
import com.squareup.moshi.JsonReader

@JsonClass(generateAdapter = true)
data class GenericWrapper<T>(
    val data: T?,
    val result: String,
    val errors: List<String>?
)


object NULL_TO_EMPTY_STRING_ADAPTER {
    @FromJson
    fun fromJson(reader: JsonReader): String {
        if (reader.peek() != JsonReader.Token.NULL) {
            return reader.nextString()
        }
        reader.nextString()
        return "string"
    }
}