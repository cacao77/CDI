package com.cacao77.event;

import java.util.Date;


public abstract class BaseEvent {

    final private long id;
    final private Date creationDate;
    final private String name;

    protected abstract void init();

    public BaseEvent(long id, String name) {

        this.id = id;
        this.name = name;
        creationDate = new Date();
        init();
    }

    public long getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return new StringBuilder("Event id:")
                .append(id)
                .append(" name:")
                .append(name)
                .append(" created")
                .append(creationDate)
                .toString();
    }
}