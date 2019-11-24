package com.sharaga.yourcityevents_android.service.validators

import java.util.regex.Pattern

public class EmailValidator: IValidator {
    override fun validate(text: String?): Boolean {
        return Pattern.compile("^[a-z0-9_+-]+(?:\\.[a-z0-9_+-]+)*@(?:[a-z0-9](?:[a-z0-9-_]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")
            .matcher(text).matches()
    }
}