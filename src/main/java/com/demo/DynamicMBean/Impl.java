package com.demo.DynamicMBean;

import com.demo.Annotation.IntDefaultValue;
import com.demo.Annotation.InterfaceAnnotation;

public interface Impl {

    @IntDefaultValue(180)
    @InterfaceAnnotation.DefaultValue(value = "ceshi", demo = "demo")
    public void showTime();

    public long getUpTime();
}

