package com.demo.Jmx;

import javax.management.Attribute;
import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.*;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AgentTest {

    public static void main(String[] args) throws Exception {
        // 下面这种方式不能再JConsole中使用
//      MBeanServer server = MBeanServerFactory.createMBeanServer();
// 首先建立一个MBeanServer,MBeanServer用来管理我们的MBean,通常是通过MBeanServer来获取我们MBean的信息，间接
// 调用MBean的方法，然后生产我们的资源的一个对象。
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        String domainName = "MyMBean";

//为MBean（下面的new Hello()）创建ObjectName实例
        ObjectName helloName = new ObjectName("Bean" + ":name=HelloWorld");
// 将new Hello()这个对象注册到MBeanServer上去
        mbs.registerMBean(new Hello(), helloName);

        int rmiPort = 8010;
        Registry registry = LocateRegistry.createRegistry(rmiPort);

        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:" + rmiPort + "/" + domainName);
        JMXConnectorServer jmxConnector = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);
        jmxConnector.start();

        System.out.println("=======================");
        JMXConnector connector = JMXConnectorFactory.connect(url);
        connector.connect();

        MBeanServerConnection server = connector.getMBeanServerConnection();
        server.setAttribute(helloName, new Attribute("Name", "测试 OK?"));
        String attrValue = server.getAttribute(helloName, "Name").toString();
        System.out.println(attrValue);

        server.invoke(helloName, "printHello", null, null);
        server.invoke(helloName, "printHello", new String[]{"牛逼了"}, new String[]{String.class.getName()});
        connector.close();
        System.out.println("=======================");
    }
}
