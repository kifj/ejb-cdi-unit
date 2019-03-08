package iocunit;

import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.oneandone.iocunit.analyzer.ClasspathHandler;

import iocunit.cdiunit.AImplementation1;

/**
 * @author aschoerk
 */
@RunWith(JUnit4.class)
public class ClasspathHandlerTest {
    @Test
    public void testSimplePackage() throws MalformedURLException {
        Set<Class<?>> result = new HashSet<>();
        final Class<AImplementation1> additionalPackageClass = AImplementation1.class;
        checkAddPackageResult(AImplementation1.class);
    }

    @Test
    public void testJarPackage() throws MalformedURLException {
        checkAddPackageResult(Assert.class);
    }

    private void checkAddPackageResult(final Class<?> additionalPackageClass) throws MalformedURLException {
        Set<Class<?>> result = new HashSet<>();
        ClasspathHandler.addPackage(additionalPackageClass, result);
        Assert.assertTrue(result.contains(additionalPackageClass));
        for (Class<?> c : result) {
            c.getPackage().equals(additionalPackageClass.getPackage());
        }
    }
}
