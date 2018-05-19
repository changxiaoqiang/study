package com.demo.test;

import com.demo.Sort.MergeSort;

public class QuickSort extends Sort {
    @Override
    public int[] sort(int[] arr, int... args) {
        if (args.length != 2) {
            return null;
        }
        int low = args[0];
        int high = args[1];
        if (low < high) {
            int mid = getMid(arr, low, high);
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
        }
        showArr(arr);
        return arr;
    }

    public int getMid(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];
            showArr(arr);
            while (low < high && arr[low] < temp) {
                low++;
            }
            arr[high] = arr[low];
            showArr(arr);
        }
        arr[low] = temp;
        //中轴记录到尾
        showArr(arr);
        return low;
    }

    public static void main(String[] args) {
        Sort sort = new QuickSort();
        int[] arr = {49, 38, 65, 97, 76, 13, 27};
        showArr(arr);
        System.out.println("====================");

        int[] result = sort.sort(arr, 0, arr.length - 1);
        System.out.println("====================");
        showArr(result);
    }
}
