package com.demo.Jmx;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.management.Attribute;
import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.*;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * HelloAgent Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 21, 2019</pre>
 */
public class HelloAgentTest {

    @Before
    public void before() throws Exception {
        HelloAgent.register();
    }

    @After
    public void after() throws Exception {
        System.out.println("after");
    }

    /**
     * Method: register()
     */
    @Test
    public void testRegister() throws Exception {
        System.out.println("test");

        int rmiPort = 8010;

        String domainName = "MyMBean";

        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:" + rmiPort + "/" + domainName);

        JMXConnector connector = JMXConnectorFactory.connect(url);
        connector.connect();
        ObjectName helloName = new ObjectName("Bean" + ":name=HelloWorld");

        MBeanServerConnection server = connector.getMBeanServerConnection();
        server.setAttribute(helloName, new Attribute("Name", "测试 OK?"));
        String attrValue = server.getAttribute(helloName, "Name").toString();
        System.out.println(attrValue);

        server.invoke(helloName, "printHello", null, null);
        server.invoke(helloName, "printHello", new String[]{"牛逼了"}, new String[]{String.class.getName()});
        connector.close();
    }



}
