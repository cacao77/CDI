package com.cacao77.event;

public class EndEvent extends BaseEvent {


    public EndEvent(long id) {
        super(id, "END");
    }

    @Override
    protected void init() {

    }
}