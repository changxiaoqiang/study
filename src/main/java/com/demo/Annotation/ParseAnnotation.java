package com.demo.Annotation;

import com.demo.Annotation.MyAnnotation.MyClassAnnotation;
import com.demo.Annotation.MyAnnotation.MyMethodAnnotation;
import com.demo.Annotation.MyAnnotation.Yts;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ParseAnnotation {
    /**
     * 解析方法注解
     *
     * @param <T>
     * @param clazz
     */
    public static <T> void parseMethod(Class<T> clazz) {
        try {
//            T obj = clazz.newInstance();
            T obj = clazz.getDeclaredConstructor(new Class[]{String.class}).newInstance("中文");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println("------START: " + method.getName() + "-------");
                MyMethodAnnotation methodAnnotation = method.getAnnotation(MyMethodAnnotation.class);
                if (methodAnnotation != null) {
                    //通过反射调用带有此注解的方法
                    method.invoke(obj, methodAnnotation.uri());
                }
                Yts yts = method.getAnnotation(Yts.class);
                if (yts != null) {
                    if (Yts.YtsType.util.equals(yts.classType())) {
                        System.out.println("this is a util method");
                    } else {
                        System.out.println("this is a other method");
                    }
                    System.out.println(Arrays.toString(yts.arr())); //打印数组
                    System.out.println(yts.color()); //输出颜色
                }
                System.out.println("------END: " + method.getName() + "-------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析类注解
     *
     * @param <T>
     * @param clazz
     */
    public static <T> void parseType(Class<T> clazz) {
        try {
            Yts yts = (Yts) clazz.getAnnotation(Yts.class);
            if (yts != null) {
                if (Yts.YtsType.util.equals(yts.classType())) {
                    System.out.println("this is a util class Yts");
                } else {
                    System.out.println("this is a other class Yts");
                }
            }
            MyClassAnnotation classAnnotation = (MyClassAnnotation) clazz.getAnnotation(MyClassAnnotation.class);
            if (classAnnotation != null) {
                System.out.println(" class info: " + classAnnotation.uri());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parseMethod(TestAnnotation.class);

        System.out.println("================");
        parseType(TestAnnotation.class);
    }
}
