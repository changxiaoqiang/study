package com.demo.test;

import java.util.ArrayList;
import java.util.List;

class SingleTon {
    public static int count1;
    public static int count2 = 1;
    private static SingleTon singleTon = new SingleTon();

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}

public class Test {

    //    @SafeVarargs // Not actually safe!
    static void m(List<String>... stringLists) {

//        Object[] array = stringLists;
//        List<Integer> tmpList = Arrays.asList(42);
//        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
        System.out.println(s);
    }

    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);

        List<String> list = new ArrayList<String>() {{
            add("bb");
        }};
        System.out.println(list.get(0));
        Test.m(new ArrayList<String>() {{
            add("aa");
            add("cc");
        }});
    }
}
