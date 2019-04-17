package com.demo.DynamicMBean;

import com.demo.Jmx.Hello;
import com.demo.Proxy.BusinessProcessorHandler;
import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import java.lang.reflect.Proxy;
import java.net.URLEncoder;

/**
 * 动态 MBbean
 */
public class Main {
    private static ObjectName objectName;
    private static MBeanServer mBeanServer;

    public static void main(String[] args) throws Exception {
//        StringBuilder sb = new StringBuilder();
//        UTF8UrlEncoder.appendEncoded(sb, "{\"content\":\"\uD83C\uDF0F\",\"extra\":\"\"}");
//        String str = URLEncoder.encode("{\"content\":\"\uD83C\uDF0F\",\"extra\":\"\"}", "UTF-8");
//        System.out.println(sb);
//        System.out.println(str);
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        init();
        System.out.println("===============================");
        manage();
    }

    private static void init() throws Exception {
        mBeanServer = MBeanServerFactory.createMBeanServer();
        objectName = new ObjectName("objectName:id=ServerMonitor1");
        /**
         * StandardMBean
         */
        ServerImpl serverImpl = new ServerImpl();
        StandardMBean standardServerMonitor = new StandardMBean(serverImpl, Impl.class);
        System.out.println(standardServerMonitor.getMBeanInterface());
//        StandardServerMonitor standardServerMonitor = new StandardServerMonitor(serverImpl, Impl.class);
        Impl impl = Impl.class.cast(standardServerMonitor.getImplementation());
        impl.showTime();
        mBeanServer.registerMBean(standardServerMonitor, objectName);

        /**
         * DynamicMBean
         */
        DynamicServerMonitor dynamicServerMonitor = new DynamicServerMonitor(serverImpl);
        ObjectName newObjectName = new ObjectName("objectName:id=ServerMonitor2");
        mBeanServer.registerMBean(dynamicServerMonitor, newObjectName);

        BusinessProcessorHandler handler = new BusinessProcessorHandler(serverImpl);
        Impl server = (Impl) Proxy.newProxyInstance(Impl.class.getClassLoader(), new Class[]{Impl.class}, handler);
        StandardServerMonitor standardMonitor = new StandardServerMonitor(server, Impl.class);
        Impl.class.cast(standardMonitor.getImplementation()).showTime();

        MBeanServerImplHandler implHandler = new MBeanServerImplHandler(Impl.class);
        Impl implServer = (Impl) Proxy.newProxyInstance(Impl.class.getClassLoader(), new Class[]{Impl.class}, implHandler);
        implServer.showTime();

    }

    private static void manage() throws Exception {
        ObjectName objectName = new ObjectName("objectName:id=ServerMonitor1");
        System.out.println(mBeanServer.getAttribute(objectName,"UpTime"));
        System.out.print("showTime:");
        mBeanServer.invoke(objectName, "showTime",null, null);
        System.out.println(mBeanServer.invoke(objectName, "showTime",null, null));

        System.out.println("1============================");
        MBeanServerHandler handler = new MBeanServerHandler(mBeanServer, objectName);
        Impl server = (Impl) Proxy.newProxyInstance(Impl.class.getClassLoader(), new Class[]{Impl.class}, handler);
        StandardServerMonitor standardMonitor = new StandardServerMonitor(server, Impl.class);
        System.out.print("Proxy:");
//        System.out.println(standardMonitor.getAttribute("UpTime"));
        Impl impl = Impl.class.cast(standardMonitor.getImplementation());
        impl.showTime();
        long time = impl.getUpTime();
        System.out.println(time);
        Thread.sleep(10);
        System.out.println("2============================");


        ObjectName newObjectName = new ObjectName("objectName:id=ServerMonitor2");
        System.out.println(mBeanServer.getAttribute(newObjectName,"UpTime"));
        System.out.print("newObjectName showTime:");
        System.out.println(mBeanServer.invoke(newObjectName, "showTime",null, null));

        System.out.println("=====");
    }
}
