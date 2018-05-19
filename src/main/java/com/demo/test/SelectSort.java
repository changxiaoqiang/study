package com.demo.test;

public class SelectSort extends Sort {
    @Override
    public int[] sort(int[] arr, int... args) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = i;
            for (int m = i; m < arr.length; m++) {
                if (arr[m] <= arr[tmp] && m > i) {
                    tmp = m;
                }
            }
            if (tmp != i) {
                swap(arr, tmp, i);
            }
            showArr(arr);
        }
        return arr;
    }
}
