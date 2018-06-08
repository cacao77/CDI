package com.cacao77.bean;

import com.cacao77.event.BaseEvent;
import com.cacao77.event.EndEvent;
import com.cacao77.event.StartupEvent;
import com.cacao77.interceptor.ExecutionMarker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.weld.bootstrap.Validator;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

@ApplicationScoped
public class Application {

    static Logger logger = LogManager.getLogger(Application.class);

    @Inject
    Event<BaseEvent> EventManager;

    @Inject
    Instance<StartupEvent> startupEvents;

    @Inject
    Instance<EndEvent> endEvents;

    @Inject
    DataReader reader;

    @PostConstruct
    public void init() {
        EventManager.fire(startupEvents.get());

    }

    @ExecutionMarker
    public void startup() {
        reader.readData();
        EventManager.fire(endEvents.get());
    }

    @PreDestroy
    public void close() {
        EventManager.fire(endEvents.get());
    }


}
