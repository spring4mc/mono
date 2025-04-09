package org.spring4mc.util.typetoken;

import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;

/**
 * Provides a factory for creating {@link TypeToken} instances.
 * The {@link TypeTokenFactory} is a singleton that can be accessed using the {@link #get()} method.
 */
public interface TypeTokenFactory {
    <T> TypeToken<T> create(@NonNull Type type, @Nullable AnnotatedElement annotatedElement);

    <T> TypeToken<T> create(@NonNull Type type, Annotation[] annotations);
}
