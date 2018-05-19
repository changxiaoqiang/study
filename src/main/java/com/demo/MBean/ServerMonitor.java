package com.demo.MBean;

public class ServerMonitor implements ServerMonitorMBean {
    private final ServerImpl target;

    public ServerMonitor(ServerImpl target){
        this.target = target;
    }

    @Override
    public String getUpTime(){
        return String.valueOf(System.currentTimeMillis() - target.startTime);
    }

    @Override
    public void printTime(){
        System.out.println(System.currentTimeMillis());
    }
}
