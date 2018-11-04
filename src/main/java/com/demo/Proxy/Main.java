package com.demo.Proxy;

import java.lang.reflect.Proxy;

/**
 * 深入理解 Java Proxy 机制
 * 动态代理
 */
public class Main {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        String saveGeneratedFiles = System.getProperty("sun.misc.ProxyGenerator.saveGeneratedFiles");
        System.out.println(saveGeneratedFiles);
        BusinessProcessorImpl bpimpl = new BusinessProcessorImpl();
        BusinessProcessorHandler handler = new BusinessProcessorHandler(bpimpl);
        BusinessProcessor bp = (BusinessProcessor) Proxy.newProxyInstance(BusinessProcessor.class.getClassLoader(), new Class[]{BusinessProcessor.class}, handler);
        bp.processBusiness();
    }
}
