package com.demo.test;

public class BubbleSort extends Sort {
    public static void main(String[] args) {
        Sort sort = new BubbleSort();
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 65};
        showArr(arr);
        System.out.println("====================");

        int[] result = sort.sort(arr);
        System.out.println("====================");
        showArr(result);
    }

    @Override
    public int[] sort(int[] arr, int... args) {
        for (int i = 0; i < arr.length; i++) {
            for (int m = 0; m < arr.length - i - 1; m++) {
                if (arr[m] >= arr[m + 1]) {
                    swap(arr, m, m + 1);
                }
            }
            showArr(arr);
        }
        return arr;
    }
}
