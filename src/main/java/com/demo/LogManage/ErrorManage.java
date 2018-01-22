package com.demo.LogManage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ErrorManage {
    private static Logger LogInfo = LogManager.getLogger("logmanage-error-logger");

    public void writeLog() {
        LogInfo.trace("write error trace");
        LogInfo.debug("write error debug");
        LogInfo.info("write error log");
        LogInfo.warn("write error warnning");
        LogInfo.error("write error error");
    }
}
