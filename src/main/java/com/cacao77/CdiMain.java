package com.cacao77;


import com.cacao77.bean.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class CdiMain {

    static Logger logger = LogManager.getLogger(CdiMain.class);

    public static void main(String[] args) {
        logger.info("Bootstrapping");

        Weld weld = new Weld();
        WeldContainer weldContainer = weld.initialize();
        weldContainer.select(Application.class).get().startup();

    }
}
