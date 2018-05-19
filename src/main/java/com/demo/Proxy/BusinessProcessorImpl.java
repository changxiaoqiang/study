package com.demo.Proxy;

public class BusinessProcessorImpl implements BusinessProcessor {
    @Override
    public void processBusiness(String param) {
        System.out.println("processing business....." + param);
    }
}
