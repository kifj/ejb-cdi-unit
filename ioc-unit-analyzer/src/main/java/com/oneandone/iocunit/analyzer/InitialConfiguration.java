package com.oneandone.iocunit.analyzer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jboss.weld.bootstrap.api.Service;

public class InitialConfiguration {

    public Class testClass;
    public Method testMethod;

    /**
     * classes initially defined to be started by Weld-SE. Producers and Themselves have priority over others
     * They get scanned for ejb-cdi-unit2-Annotations
     */
    public Set<Class<?>> initialClasses = new HashSet<>();
    /**
     * Classes to be included as testclasses. These are started. They themselves and their producers get priority over
     * SuT.
     */
    public Set<Class<?>> testClasses = new HashSet<>();
    /**
     * All Classes in the classpath of these classes are to be included as testclasses.
     * These are started. They themselves and their producers get priority over
     * SuT.
     */
    public Set<Class<?>> testClasspaths = new HashSet<>();

    /**
     * Classes to be declared as beans to CDI, if there is no collision with classes produced by the Testconfiguration.
     */
    public Set<Class<?>> sutClasses = new HashSet<>();
    /**
     * Classes of the packages of these classes are included if necessary to support Injects
     */
    public Set<Class<?>> sutPackages = new HashSet<>(); // managed bean classes in packages of these classes will be created if necessary
    /**
     * Classes of the packages of these classes are included if necessary to support Injects
     */
    public Set<Class<?>> testPackages = new HashSet<>(); // managed bean classes in packages of these classes will be created if necessary
    /**
     * Classes of the classpaths of these classes are included if necessary to support Injects
     */
    public Set<Class<?>> sutClasspath = new HashSet<>(); // managed bean classes in classpath of these classes will be created if necessary

    /**
     * Classes of the classpaths of these classes are included if necessary to support Injects
     */
    public Set<Class<?>> testClasspath = new HashSet<>(); // managed bean classes in classpath of these classes will be created if necessary

    /**
     * Classes which should be enabled Alternatives (makes only sense if they are annotated as @Alternative) or
     * stereotype-annoations which should define enabled Alternatives (makes only sense if they are annotated as @Alternative)
     */
    public Set<Class<?>> enabledAlternatives = new HashSet<>();

    /**
     * Classes which must be excludedClasses if they would occure in the list of beanclasses used to start Weld-SE
     */
    public Set<Class<?>> excludedClasses = new HashSet<>();

    public Map<Class<?>, Service> services = new HashMap<>();

    public InitialConfiguration testClasspath(Class<?> clazz) {
        testClasspath.add(clazz);
        return this;
    }

    public InitialConfiguration theTestClass(Class<?> clazz) {
        setTestClass(clazz);
        return testClass(clazz);
    }

    public InitialConfiguration testClass(Class<?> clazz) {
        testClasses.add(clazz);
        return this;
    }

    public InitialConfiguration testPackage(Class<?> clazz) {
        testPackages.add(clazz);
        return this;
    }

    public InitialConfiguration sutClasspath(Class<?> clazz) {
        sutClasspath.add(clazz);
        return this;
    }

    public InitialConfiguration sutClass(Class<?> clazz) {
        sutClasses.add(clazz);
        return this;
    }

    public InitialConfiguration sutPackage(Class<?> clazz) {
        sutPackages.add(clazz);
        return this;
    }

    public InitialConfiguration enabledAlternatives(Class<?> clazz) {
        enabledAlternatives.add(clazz);
        return this;
    }

    public InitialConfiguration exclude(Class<?> clazz) {
        excludedClasses.add(clazz);
        return this;
    }

    public InitialConfiguration setTestClass(final Class<?> aClass) {
        testClass = aClass;
        return this;
    }
}
