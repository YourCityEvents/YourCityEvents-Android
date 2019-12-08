package com.sharaga.yourcityevents_android.utility;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class NullToEmptyListJsonAdapter extends JsonAdapter<List<?>> {

    public static final Factory FACTORY = new Factory() {
        @Nullable
        @Override
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> annotations, Moshi moshi) {
            if (!annotations.isEmpty()) {
                return null;
            }
            if (Types.getRawType(type) != List.class) {
                return null;
            }
            JsonAdapter<List<?>> objectJsonAdapter = moshi.nextAdapter(this, type, annotations);
            return new NullToEmptyListJsonAdapter(objectJsonAdapter);
        }
    };

    private final JsonAdapter<List<?>> delegate;

    private NullToEmptyListJsonAdapter(JsonAdapter<List<?>> delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<?> fromJson(JsonReader reader) throws IOException {
        if (reader.peek() == JsonReader.Token.NULL) {
            reader.skipValue();
            return Collections.emptyList();
        }
        return delegate.fromJson(reader);
    }

    @Override
    public void toJson(@NotNull JsonWriter writer, @Nullable List<?> value) throws IOException {
        if (value == null) {
            throw new IllegalStateException("Wrap JsonAdapter with .nullSafe().");
        }
        delegate.toJson(writer, value);
    }
}
