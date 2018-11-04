package com.demo.Annotation;

import com.sun.org.glassfish.gmbal.Description;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Description("This MBean used to modified the attribute related rcapns config.")
public interface InterfaceAnnotation {
    @Description("The interval about refresh.")
    @IntDefaultValue(3600 * 2)
    public int getCfgRefreshInterval();

    public void setCfgRefreshInterval(int interval);

    @Description("The interval of refresh cache. unit second.")
    @IntDefaultValue(180)
    public int getRefreshInterval();

    public void setRefreshInterval(int capacity);

    @IntDefaultValue(60 * 5)
    public int getCfgBlockDuration();

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE, ElementType.METHOD})
    public @interface DefaultValue {
        String value() default "Default value";

        String demo() default ("Demo");
    }
}
