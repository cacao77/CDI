package com.cacao77.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import java.util.concurrent.atomic.AtomicLong;

@Default
public class IdGenerator {



    AtomicLong current;

    protected void init(){
        current = new AtomicLong(0);
    }

    @PostConstruct
    private void _init() {
       init();
    }

    public long generateId() {
        return current.addAndGet(1);
    }

}
