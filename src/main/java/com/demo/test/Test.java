package com.demo.test;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count2 = 0;
=======
class SingleTon {
    public static int count1;
    public static int count2 = 1;
    private static SingleTon singleTon = new SingleTon();
>>>>>>> 375a329dbe180b244d4b347019e02040faa42f34

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}

public class Test {
<<<<<<< HEAD

//    @SafeVarargs // Not actually safe!
    static void m(List<String>... stringLists) {

//        Object[] array = stringLists;
//        List<Integer> tmpList = Arrays.asList(42);
//        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
        System.out.println(s);
    }

=======
>>>>>>> 375a329dbe180b244d4b347019e02040faa42f34
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
<<<<<<< HEAD

        List<String> list = new ArrayList<String>() {{
            add("bb");
        }};
        System.out.println(list.get(0));
        Test.m(new ArrayList<String>() {{
            add("aa");
            add("cc");
        }});
=======
>>>>>>> 375a329dbe180b244d4b347019e02040faa42f34
    }
}
