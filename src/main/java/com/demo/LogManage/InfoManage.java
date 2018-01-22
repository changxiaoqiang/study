package com.demo.LogManage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InfoManage {
    private static Logger LogInfo = LogManager.getLogger("logmanage-logger");
    private static Logger LogInfoCommon = LogManager.getLogger("logger");

    public void writeLog() {
        LogInfoCommon.trace("write error trace");
        LogInfoCommon.debug("write info debug");
        LogInfoCommon.info("write info log");
        LogInfoCommon.warn("write info warnning");
        LogInfoCommon.error("write info error");


        LogInfo.trace("write error trace");
        LogInfo.debug("write info debug");
        LogInfo.info("write info log");
        LogInfo.warn("write info warnning");
        LogInfo.error("write info error");
    }
}
