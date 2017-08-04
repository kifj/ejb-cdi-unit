package com.oneandone.ejbcdiunit.camunda;

import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.container.RuntimeContainerDelegate;
import org.camunda.bpm.engine.cdi.BusinessProcess;
import org.camunda.bpm.engine.impl.ProcessEngineImpl;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.oneandone.ejbcdiunit.CdiTestConfig;
import com.oneandone.ejbcdiunit.EjbUnitRule;

/**
 * @author aschoerk
 */
public class EjbCamundaUnitRule implements TestRule {

    private final Object testInstance;
    EjbUnitRule ejbUnitRule;
    private ProcessEngineRule processEngineRule;
    private ProcessEngineConfigurationImpl processEngineConfiguration;

    public EjbCamundaUnitRule(Object testInstance) {
        this(testInstance, null);
    }

    public EjbCamundaUnitRule(Object testInstance, CdiTestConfig cdiTestConfig) {
        CdiTestConfig cdiTestConfig1 = cdiTestConfig != null ? cdiTestConfig : new CdiTestConfig();
        this.testInstance = testInstance;

        ejbUnitRule = new EjbUnitRule(testInstance,
                cdiTestConfig1
                        .addClass(CdiUnitContextAssociationManager.class)
                        .addClassPath(BusinessProcess.class));
        this.processEngineRule = new ProcessEngineRule(true);
    }

    public ProcessEngineRule getProcessEngineRule() {
        return processEngineRule;
    }

    public EjbUnitRule getEjbUnitRule() {
        return ejbUnitRule;
    }

    public ProcessEngineConfigurationImpl getProcessEngineConfiguration() {
        return processEngineConfiguration;
    }

    /**
     * Modifies the method-running {@link Statement} to implement this test-running rule.
     *
     * @param base
     *            The {@link Statement} to be modified
     * @param description
     *            A {@link Description} of the test implemented in {@code base}
     * @return a new statement, which may be the same as {@code base}, a wrapper around {@code base}, or a completely new Statement.
     */
    @Override
    public Statement apply(Statement base, Description description) {
        // TestHelper.closeProcessEngines();
        Statement result = processEngineRule.apply(ejbUnitRule.apply(base, description), description);
        if (BpmPlatform.getProcessEngineService().getDefaultProcessEngine() == null) {
            RuntimeContainerDelegate.INSTANCE.get().registerProcessEngine(processEngineRule.getProcessEngine());
        }

        this.processEngineConfiguration =
                ((ProcessEngineImpl) BpmPlatform.getProcessEngineService().getDefaultProcessEngine()).getProcessEngineConfiguration();
        return result;

    }
}