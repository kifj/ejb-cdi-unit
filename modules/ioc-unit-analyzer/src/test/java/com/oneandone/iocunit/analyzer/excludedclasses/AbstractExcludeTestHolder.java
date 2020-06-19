package com.oneandone.iocunit.analyzer.excludedclasses;

import com.oneandone.iocunit.analyzer.annotations.ExcludedClasses;
import com.oneandone.iocunit.analyzer.annotations.SutPackages;
import com.oneandone.iocunit.analyzer.excludedclasses.pcktoinclude.ToExclude;
import com.oneandone.iocunit.analyzer.excludedclasses.pcktoinclude.ToInclude;

import org.junit.BeforeClass;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * @author aschoerk
 */
public abstract class AbstractExcludeTestHolder {

    @BeforeClass
    public static void initToInclude() {
        ToInclude.count = 0;
    }

    @SutPackages({ ToInclude.class })
    @ExcludedClasses({ ToExclude.class })
    static abstract class AbstractExcludeTest {
        @Inject
        ToInclude toInclude;

        @Produces  // not effective in abstract class
        ToExclude.ToExcludeProduced tmp = new ToExclude.ToExcludeProduced(11); // no produces clash with excluded ToExclude

        @Inject
        ToExclude.ToExcludeProduced toExcludeProduced;

    }

}
