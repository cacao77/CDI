package com.cacao77.interceptor;

import com.cacao77.bean.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class ExecutionMarkerInterceptor {

    static Logger logger = LogManager.getLogger(DataReader.class);

    @AroundInvoke
    public Object measure(InvocationContext invocationContext) throws Exception {

        logger.info("Going to execute " + invocationContext.getMethod().getName());
        long start = System.currentTimeMillis();
        Object result = invocationContext.proceed();
        logger.info(invocationContext.getMethod().getName() + " executed in " + (System.currentTimeMillis() - start));
        return result;
    }

}
