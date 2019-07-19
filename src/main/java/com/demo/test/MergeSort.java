package com.demo.test;

public class MergeSort extends Sort {
    public static void main(String[] args) {
        Sort sort = new MergeSort();
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49};
        showArr(arr);
        System.out.println("====================");

        int[] result = sort.sort(arr, 0, arr.length - 1);
        System.out.println("====================");
        showArr(result);
    }

    @Override
    public int[] sort(int[] arr, int... args) {
        if (args.length != 2) {
            return null;
        }
        int low = args[0];
        int high = args[1];
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
            showArr(arr);
        }
        return arr;
    }

    public void merge(int[] arr, int low, int mid, int high) {
        System.out.println(low + "\t" + mid + "\t" + high);
        int[] tmp = new int[high - low + 1];
        int l = low;
        int r = mid + 1;
        int k = 0;
        while (l <= mid && r <= high) {
            if (arr[l] < arr[r]) {
                tmp[k++] = arr[l++];
            } else {
                tmp[k++] = arr[r++];
            }
        }

        while (l <= mid) {
            tmp[k++] = arr[l++];
        }
        while (r <= high) {
            tmp[k++] = arr[r++];
        }
        showArr(tmp);
        for (int i = 0; i < tmp.length; i++) {
            arr[i + low] = tmp[i];
        }
    }
}
