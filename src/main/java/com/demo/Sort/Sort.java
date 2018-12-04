package com.demo.Sort;

public abstract class Sort {
    public abstract int[] sort(int[] numbers);

    public static void showArr(int[] arr) {
        System.out.print("[");
        for (int num : arr) {
            System.out.print(num + ",");
        }
        System.out.println("]");
    }
}
