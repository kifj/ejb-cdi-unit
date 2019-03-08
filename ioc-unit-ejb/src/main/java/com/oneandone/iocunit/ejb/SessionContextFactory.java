package com.oneandone.iocunit.ejb;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import com.oneandone.iocunit.ejb.resourcesimulators.SessionContextSimulation;

/**
 * @author aschoerk
 */
@SupportEjbExtended
public class SessionContextFactory {

    @Inject
    BeanManager beanManager;

    @Produces
    @ResourceQualifier(name = "javax.ejb.SessionContext")
    SessionContextSimulation createSessionContext(InjectionPoint ip) {
        SessionContextSimulation injectedBean = new SessionContextSimulation("dummy");
        injectedBean.setContainer(ip.getBean(), beanManager);
        return injectedBean;
    }

}
