package com.sharaga.yourcityevents_android.validators

import java.util.regex.Pattern

class EmailValidator: IValidator {

    override fun validate(text: CharSequence?): Boolean {
        text ?: return false
        return Pattern.compile("^[a-zA-Z0-9_+-]+(?:\\.[a-z0-9_+-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-_]*[a-z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?$")
            .matcher(text).matches()
    }
}
