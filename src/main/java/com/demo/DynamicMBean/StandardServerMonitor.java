package com.demo.DynamicMBean;

import javax.management.*;

public class StandardServerMonitor extends StandardMBean {
    private final Impl target;
    private MBeanInfo mBeanInfo;

    public StandardServerMonitor(Impl target, Class inf) throws NotCompliantMBeanException {
        super(target, inf);
        this.target = target;
    }

    // 实现获取被管理的 ServerImpl 的 upTime
    public long upTime() {
        ServerImpl serverTarget = (ServerImpl) target;
        return System.currentTimeMillis() - serverTarget.startTime;
    }

    /**
     * Obtain the value of a specific attribute of the Dynamic MBean.
     *
     * @param attribute The name of the attribute to be retrieved
     * @return The value of the attribute retrieved.
     * @throws AttributeNotFoundException
     * @throws MBeanException Wraps a <CODE>java.lang.Exception</CODE> thrown by the MBean's getter.
     * @throws ReflectionException Wraps a <CODE>java.lang.Exception</CODE> thrown while trying to invoke the getter.
     * @see #setAttribute
     */
    @Override
    public Object getAttribute(String attribute) throws AttributeNotFoundException, MBeanException, ReflectionException {
        if (attribute.equals("UpTime")) {
            return upTime();
        }
        return null;
    }

    /**
     * Set the value of a specific attribute of the Dynamic MBean.
     *
     * @param attribute The identification of the attribute to
     *                  be set and  the value it is to be set to.
     * @throws AttributeNotFoundException
     * @throws InvalidAttributeValueException
     * @throws MBeanException Wraps a <CODE>java.lang.Exception</CODE> thrown by the MBean's setter.
     * @throws ReflectionException Wraps a <CODE>java.lang.Exception</CODE> thrown while trying to invoke the MBean's setter.
     * @see #getAttribute
     */
    @Override
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {

    }

    /**
     * Get the values of several attributes of the Dynamic MBean.
     *
     * @param attributes A list of the attributes to be retrieved.
     * @return The list of attributes retrieved.
     * @see #setAttributes
     */
    @Override
    public AttributeList getAttributes(String[] attributes) {
        return null;
    }

    /**
     * Sets the values of several attributes of the Dynamic MBean.
     *
     * @param attributes A list of attributes: The identification of the
     *                   attributes to be set and  the values they are to be set to.
     * @return The list of attributes that were set, with their new values.
     * @see #getAttributes
     */
    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        return null;
    }

    /**
     * Allows an action to be invoked on the Dynamic MBean.
     *
     * @param actionName The name of the action to be invoked.
     * @param params     An array containing the parameters to be set when the action is
     *                   invoked.
     * @param signature  An array containing the signature of the action. The class objects will
     *                   be loaded through the same class loader as the one used for loading the
     *                   MBean on which the action is invoked.
     * @return The object returned by the action, which represents the result of
     * invoking the action on the MBean specified.
     * @throws MBeanException Wraps a <CODE>java.lang.Exception</CODE> thrown by the MBean's invoked method.
     * @throws ReflectionException Wraps a <CODE>java.lang.Exception</CODE> thrown while trying to invoke the method
     */
    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {
        ServerImpl serverTarget = (ServerImpl) target;

        if (actionName.equals("showTime")) {
            try {
                return ServerImpl.class.getMethod(actionName).invoke(serverTarget);
            } catch (Exception e) {

            }
        }
        return System.currentTimeMillis() - serverTarget.startTime;
    }

    /**
     * Provides the exposed attributes and actions of the Dynamic MBean using an MBeanInfo object.
     *
     * @return An instance of <CODE>MBeanInfo</CODE> allowing all attributes and actions
     * exposed by this Dynamic MBean to be retrieved.
     */
    @Override
    public MBeanInfo getMBeanInfo() {
        mBeanInfo = super.getMBeanInfo();
        return mBeanInfo;
    }
}
