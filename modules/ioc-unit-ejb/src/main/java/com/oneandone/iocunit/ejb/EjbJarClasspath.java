package com.oneandone.iocunit.ejb;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author aschoerk
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EjbJarClasspath {
    /**
     * @return Array of classes to exclude from CDI during testing.
     */
    public Class<?> value();
}
