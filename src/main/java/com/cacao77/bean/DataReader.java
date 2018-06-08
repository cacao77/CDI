package com.cacao77.bean;

import com.cacao77.event.EndEvent;
import com.cacao77.event.StartupEvent;
import com.cacao77.interceptor.ExecutionMarker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.event.Observes;

public class DataReader {

    static Logger logger = LogManager.getLogger(DataReader.class);

    public void handleStartup(@Observes StartupEvent event) {
        logger.info("Receive " + event);

    }

    public void handleEnd(@Observes EndEvent event) {
        logger.info("Receive " + event);

    }

    @ExecutionMarker
    public void readData() {
    }


}
