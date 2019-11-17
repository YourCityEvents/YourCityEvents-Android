package com.sharaga.yourcityevents_android.model

data class GenericResponse<T>(
    val data: T,
    val result: String,
    val errors: List<String>
)