package com.cacao77.bean;


import com.cacao77.event.EndEvent;
import com.cacao77.event.StartupEvent;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class EventFactory {

    @Inject
    IdGenerator idGenerator;

    @Produces
    StartupEvent getStartEvent() {
        return new StartupEvent(idGenerator.generateId());
    }

    @Produces
    EndEvent getEndEvent() {
        return new EndEvent(idGenerator.generateId());
    }

}
