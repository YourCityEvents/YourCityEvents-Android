package com.sharaga.yourcityevents_android.validators

import java.util.regex.Pattern

class PasswordValidator: IValidator {

    override fun validate(text: CharSequence?): Boolean {
        text ?: return false
        return Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])[0-9A-Za-z!@#\$%?]{8,20}\$")
            .matcher(text).matches()
    }
}
