package com.sharaga.yourcityevents_android.network.validators

import java.util.regex.Pattern

class EmailValidator: IValidator {
    override fun validate(text: String?): Boolean {
        return Pattern.compile("^[a-zA-Z0-9_+-]+(?:\\.[a-z0-9_+-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-_]*[a-z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?$")
            .matcher(text).matches()
    }
}