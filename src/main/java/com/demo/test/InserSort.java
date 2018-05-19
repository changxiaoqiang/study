package com.demo.test;

public class InserSort extends Sort {
    @Override
    public int[] sort(int[] arr, int... args) {
        int m = 0;
        int tmp = 0;
        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            for (m = i; m > 0; m--) {
                if (tmp < arr[m - 1]) {
                    arr[m] = arr[m - 1];
                } else break;
            }
            arr[m] = tmp;
            showArr(arr);
        }
        return arr;
    }

    public static void main(String[] args) {
        Sort sort = new InserSort();
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 65};
        showArr(arr);
        System.out.println("====================");

        int[] result = sort.sort(arr);
        System.out.println("====================");
        showArr(result);
    }
}
