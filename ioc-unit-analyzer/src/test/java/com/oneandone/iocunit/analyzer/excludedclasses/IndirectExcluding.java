package com.oneandone.iocunit.analyzer.excludedclasses;

import com.oneandone.iocunit.analyzer.BaseTest;
import com.oneandone.iocunit.analyzer.annotations.ExcludedClasses;
import com.oneandone.iocunit.analyzer.excludedclasses.pcktoinclude.ToExclude;

/**
 * @author aschoerk
 */

public class IndirectExcluding extends BaseTest {
    @ExcludedClasses({ToExclude.class})
    static class Test {

    }

    @org.junit.Test
    public void test() {
        createTest(Test.class);
    }
}
