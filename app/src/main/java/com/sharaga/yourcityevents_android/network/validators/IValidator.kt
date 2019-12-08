package com.sharaga.yourcityevents_android.network.validators


public interface IValidator {
    fun validate(text: String?): Boolean
}