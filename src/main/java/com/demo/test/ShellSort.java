package com.demo.test;

public class ShellSort extends Sort {
    public static void main(String[] args) {
        Sort sort = new ShellSort();
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 65};
        showArr(arr);
        System.out.println("====================");

        int[] result = sort.sort(arr);
        System.out.println("====================");
        showArr(result);
    }

    @Override
    public int[] sort(int[] arr, int... args) {
        int m = 0;
        int tmp = 0;
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < arr.length; i++) {
                tmp = arr[i];
                for (m = i; m >= increment; m -= increment) {
                    if (tmp < arr[m - increment]) {
                        arr[m] = arr[m - increment];
                    } else break;
                }
                arr[m] = tmp;
                showArr(arr);
            }
        }
        return arr;
    }
}
