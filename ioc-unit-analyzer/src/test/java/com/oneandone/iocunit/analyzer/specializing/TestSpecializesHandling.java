package com.oneandone.iocunit.analyzer.specializing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.oneandone.iocunit.analyzer.BaseTest;
import com.oneandone.iocunit.analyzer.specializing.sutsamples.BaseClass;
import com.oneandone.iocunit.analyzer.specializing.sutsamples.SpecializingClass;
import com.oneandone.iocunit.analyzer.specializing.testsamples.TestWithBaseAsSutClasspathBaseAsInject;
import com.oneandone.iocunit.analyzer.specializing.testsamples.TestWithBaseAsSutClassBaseAsInject;
import com.oneandone.iocunit.analyzer.specializing.testsamples.TestWithBaseAsSutClassSpecAsInject;
import com.oneandone.iocunit.analyzer.specializing.testsamples.TestWithBaseAsSutClasspathSpecAsInject;
import com.oneandone.iocunit.analyzer.specializing.testsamples.TestWithBothBSAsSutClassBaseAsInject;
import com.oneandone.iocunit.analyzer.specializing.testsamples.TestWithBothBSAsSutClassSpecAsInject;
import com.oneandone.iocunit.analyzer.specializing.testsamples.TestWithBothSBAsSutClassBaseAsInject;
import com.oneandone.iocunit.analyzer.specializing.testsamples.TestWithBothSBAsSutClassSpecAsInject;
import com.oneandone.iocunit.analyzer.specializing.testsamples.TestWithSpecAsSutClasspathBaseAsInject;
import com.oneandone.iocunit.analyzer.specializing.testsamples.TestWithSpecAsSutClasspathSpecAsInject;
import com.oneandone.iocunit.analyzer.specializing.testsamples.TestWithSpecializingAsSutClassBaseAsInject;
import com.oneandone.iocunit.analyzer.specializing.testsamples.TestWithSpecializingAsSutClassSpecAsInject;

/**
 * @author aschoerk
 */
@RunWith(JUnit4.class)
public class TestSpecializesHandling extends BaseTest {

    @Test
    public void testTestWithBaseAsSutClassBaseAsInject() {
        createTest(TestWithBaseAsSutClassBaseAsInject.class);
        // knows nothing about specializing class, so only BaseClass can be used
        assertTrue(toBeStarted.contains(BaseClass.class));
    }
    @Test
    public void testTestWithBaseAsSutClassSpecAsInject() {
        createTest(TestWithBaseAsSutClassSpecAsInject.class);
        check();
    }
    @Test
    public void testTestWithSpecializingAsSutClassBaseAsInject() {
        createTest(TestWithSpecializingAsSutClassBaseAsInject.class);
        check();
    }
    @Test
    public void testTestWithSpecializingAsSutClassSpecAsInject() {
        createTest(TestWithSpecializingAsSutClassSpecAsInject.class);
        check();
    }

    @Test
    public void testTestWithBothBSAsSutClassBaseAsInject() {
        createTest(TestWithBothBSAsSutClassBaseAsInject.class);
        check();
    }
    @Test
    public void testTestWithBothBSAsSutClassSpecAsInject() {
        createTest(TestWithBothBSAsSutClassSpecAsInject.class);
        check();
    }

    @Test
    public void testTestWithBothSBAsSutClassBaseAsInject() {
        createTest(TestWithBothSBAsSutClassBaseAsInject.class);
        check();
    }
    @Test
    public void testTestWithBothSBAsSutClassSpecAsInject() {
        createTest(TestWithBothSBAsSutClassSpecAsInject.class);
        check();
    }

    @Test
    public void testTestWithSpecAsSutClasspathBaseAsInject() {
        createTest(TestWithSpecAsSutClasspathBaseAsInject.class);
        check();
    }

    @Test
    public void testTestWithBaseAsSutClasspathBaseAsInject() {
        createTest(TestWithBaseAsSutClasspathBaseAsInject.class);
        check();
    }

    @Test
    public void testTestWithSpecAsSutClasspathSpecAsInject() {
        createTest(TestWithSpecAsSutClasspathSpecAsInject.class);
        check();
    }

    @Test
    public void testTestWithBaseAsSutClasspathSpecAsInject() {
        createTest(TestWithBaseAsSutClasspathSpecAsInject.class);
        check();
    }

    private void check() {
        assertTrue(toBeStarted.contains(BaseClass.class));
        assertTrue(toBeStarted.contains(SpecializingClass.class));
    }

}
