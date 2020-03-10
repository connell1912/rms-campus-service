package com.rms.log;

import org.apache.log4j.Logger;

public class Log4J {
    
    public static Logger log = Logger.getLogger(Log4J.class.getName());

    private Log4J() {
        super();
    }
}