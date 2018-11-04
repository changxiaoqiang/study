package com.demo.DynamicMBean;

public class ServerImpl implements Impl {
    public final long startTime;
    public ServerImpl() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void showTime() {
        System.out.println("?????");
        System.out.println(System.currentTimeMillis());
    }

    @Override
    public long getUpTime() {
        return System.currentTimeMillis();
    }
}
