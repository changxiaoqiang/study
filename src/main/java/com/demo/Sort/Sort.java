package com.demo.Sort;

public abstract class Sort {
    public static void showArr(int[] arr) {
        System.out.print("[");
        for (int num : arr) {
            System.out.print(num + ",");
        }
        System.out.println("]");
    }

    public abstract int[] sort(int[] numbers);
}
