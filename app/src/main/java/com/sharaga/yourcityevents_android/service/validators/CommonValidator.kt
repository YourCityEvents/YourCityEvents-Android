package com.sharaga.yourcityevents_android.service.validators

class CommonValidator: IValidator {
    override fun validate(text: String?): Boolean {
        val text = text ?: return false
        return text.isNotEmpty()
    }
}