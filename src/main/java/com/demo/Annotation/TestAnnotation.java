package com.demo.Annotation;

import com.demo.Annotation.MyAnnotation.*;
import com.sun.org.glassfish.gmbal.Description;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


@MyClassAnnotation(desc = "The class", uri = "com.test.annotation.Test")
@Yts(classType = Yts.YtsType.service)
public class TestAnnotation {
    @MyFieldAnnotation(desc = "The class field", uri = "com.test.annotation.Test#id")
    private String id;

    @MyConstructorAnnotation(desc = "The class constructor", uri = "com.test.annotation.Test#MySample")
    public TestAnnotation() {
    }

//    @MyMethodAnnotation(desc = "The class method getId", uri = "com.test.annotation.Test#getId")
    public String getId() {
        return id;
    }

    @MyMethodAnnotation(desc = "The class method", uri = "com.test.annotation.Test#setId")
    public void setId(String id) {
        System.out.println(" method info: " + id);
        this.id = id;
    }

    @MyMethodAnnotation(desc = "The class method sayHello", uri = "com.test.annotation.Test#sayHello")
    @Yts
    public void sayHello(String name) {
        if (name == null || name.equals("")) {
            System.out.println("hello world!");
        } else {
            System.out.println(name + "\t:say hello world!");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(InterfaceAnnotation.class.getAnnotation(Description.class).value());
        System.out.println(InterfaceAnnotation.class.getDeclaredMethod("getRefreshInterval"));
        System.out.println(InterfaceAnnotation.class.getDeclaredMethod("getRefreshInterval").getAnnotation(IntDefaultValue.class).value());
        System.out.println(InterfaceAnnotation.DefaultValue.class);

        Class<TestAnnotation> clazz = TestAnnotation.class;
        // 得到类注解
        MyClassAnnotation myClassAnnotation = clazz.getAnnotation(MyClassAnnotation.class);
        System.out.println(myClassAnnotation.desc() + " " + myClassAnnotation.uri());

        // 得到构造方法注解
        Constructor<TestAnnotation> cons = clazz.getConstructor(new Class[]{});
        MyConstructorAnnotation myConstructorAnnotation = cons.getAnnotation(MyConstructorAnnotation.class);
        System.out.println(myConstructorAnnotation.desc() + " " + myConstructorAnnotation.uri());

        // 获取方法注解
        Method method = clazz.getMethod("setId", new Class[]{String.class});

        MyMethodAnnotation myMethodAnnotation = method.getAnnotation(MyMethodAnnotation.class);
        System.out.println(myMethodAnnotation.desc() + " " + myMethodAnnotation.uri());
        clazz.newInstance().setId("123");

        // 获取字段注解
        Field field = clazz.getDeclaredField("id");
        MyFieldAnnotation myFieldAnnotation = field.getAnnotation(MyFieldAnnotation.class);
        System.out.println(myFieldAnnotation.desc() + " " + myFieldAnnotation.uri());
    }
}
