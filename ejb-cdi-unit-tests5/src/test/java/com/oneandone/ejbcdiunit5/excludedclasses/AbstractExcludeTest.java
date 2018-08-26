package com.oneandone.ejbcdiunit5.excludedclasses;

import com.oneandone.ejbcdiunit.cdiunit.ExcludedClasses;
import com.oneandone.ejbcdiunit5.JUnit5Extension;
import com.oneandone.ejbcdiunit5.excludedclasses.pcktoinclude.ToExclude;
import com.oneandone.ejbcdiunit5.excludedclasses.pcktoinclude.ToInclude;
import org.jglue.cdiunit.AdditionalPackages;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author aschoerk
 */
@ExtendWith(JUnit5Extension.class)
@AdditionalPackages({ ToInclude.class })
@ExcludedClasses({ ToExclude.class })
public abstract class AbstractExcludeTest {

    @Inject
    ToInclude toInclude;
    @Produces
    ToExclude.ToExcludeProduced tmp = new ToExclude.ToExcludeProduced(11); // no produces clash with excluded ToExclude
    @Inject
    ToExclude.ToExcludeProduced toExcludeProduced;

    @BeforeAll
    public static void initToInclude() {
        ToInclude.count = 0;
    }

    @Test
    public void test() {
        assertThat(toInclude.count, is(1));
        assertThat(toExcludeProduced.getValue(), is(11));
    }
}
