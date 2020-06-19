package com.oneandone.iocunit.resteasy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author aschoerk
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface JaxRSClasses {
    /**
     * @return Array of classes define as JaxRS Resources or Providers
     */
    public Class<?>[] value();

    /*
     * @return true, if only classes defined by annotation should be recognized as JAXRS-Classes
     *               this holds as soon as one true is recognized during scanning.
     */
    public boolean onlyDefinedByAnnotation() default false;

}
