package com.oneandone.iocunit.ejb.jms;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author aschoerk
 */
@Singleton
public class JmsProducers {
    @Inject
    private JmsSingletons jmsSingletons;


    /**
     * called by CDI on each @Inject Queue. SupportEjb added this when @Resource was found
     * @param ip information about the injectionpoint can be used to analyze the annotations. - Queuename, ...
     * @return representation of the Queue to be injected
     */
    @Produces
    public Queue createQueue(InjectionPoint ip) {
        String name = JmsMocksFactory.getResourceName(ip);
        return jmsSingletons.getDestinationManager().createQueue(JmsMocksFactory.calculateCommonName(name));
    }

    /**
     * called by CDI on each @Inject Topic. SupportEjb added this when @Resource was found
     * @param ip information about the injectionpoint can be used to analyze the annotations. - Topicname, ...
     * @return representation of the Topic to be injected
     */
    @Produces
    public Topic createTopic(InjectionPoint ip) {
        String name = JmsMocksFactory.getResourceName(ip);
        return jmsSingletons.getDestinationManager().createTopic(JmsMocksFactory.calculateCommonName(name));
    }


}
