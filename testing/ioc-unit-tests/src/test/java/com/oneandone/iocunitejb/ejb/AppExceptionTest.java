package com.oneandone.iocunitejb.ejb;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.oneandone.iocunit.IocUnitRunner;
import com.oneandone.iocunit.analyzer.annotations.SutPackages;
import com.oneandone.iocunit.analyzer.annotations.TestClasses;
import com.oneandone.iocunit.analyzer.annotations.TestPackages;
import com.oneandone.iocunit.ejb.EjbJarClasspath;
import com.oneandone.iocunit.jpa.XmlLessPersistenceFactory;
import com.oneandone.iocunitejb.ejbs.appexc.TestBaseClass;
import com.oneandone.iocunitejb.entities.TestEntity1;

/**
 * @author aschoerk
 */
@RunWith(IocUnitRunner.class)
@TestClasses({ XmlLessPersistenceFactory.class })
@TestPackages(TestBaseClass.class)
@SutPackages({ TestEntity1.class })
@EjbJarClasspath(TestBaseClass.class)
public class AppExceptionTest extends TestBaseClass {

    @Override
    @Test
    public void testAppExcInCurrentTra() throws Throwable {
        super.testAppExcInCurrentTra();
    }

    @Override
    @Test
    public void testDeclaredAppExcInCurrentTra() throws Throwable {
        super.testDeclaredAppExcInCurrentTra();
    }

    @Override
    @Test
    public void testDeclaredAppRtExcInCurrentTra() throws Throwable {
        super.testDeclaredAppRtExcInCurrentTra();
    }

    @Override
    @Test
    public void testAppRTExcInCurrentTra() throws Throwable {
        super.testAppRTExcInCurrentTra();
    }

    @Override
    @Test
    public void testAppExcInRequired() throws Throwable {
        super.testAppExcInRequired();
    }

    @Override
    @Test
    public void testAppRTExcInRequired() throws Throwable {
        super.testAppRTExcInRequired();
    }

    @Override
    @Test
    public void testAppExcInRequiresNew() throws Throwable {
        super.testAppExcInRequiresNew();
    }

    @Override
    @Test
    public void testAppRTExcInRequiresNew() throws Throwable {
        super.testAppRTExcInRequiresNew();
    }

    @Override
    @Test
    public void testAppExcInSupports() throws Throwable {
        super.testAppExcInSupports();
    }

    @Override
    @Test
    public void testAppRTExcInSupports() throws Throwable {
        super.testAppRTExcInSupports();
    }

    @Override
    @Test
    public void testAppExcInNotSupported() throws Throwable {
        super.testAppExcInNotSupported();
    }

    @Override
    @Test
    public void testAppRTExcInNotSupported() throws Throwable {
        super.testAppRTExcInNotSupported();
    }


}
