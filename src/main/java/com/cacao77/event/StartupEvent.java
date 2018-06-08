package com.cacao77.event;

public class StartupEvent extends BaseEvent {


    public StartupEvent(long id) {
        super(id,"START");
    }

    @Override
    protected void init() {

    }
}