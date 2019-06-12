package com.demo.test;

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
        return arr;
    }

    public int getMid(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        showArr(arr);
        //中轴记录到尾
        return low;
    }

    public static void main(String[] args) {
        Sort sort = new QuickSort();
        int[] arr = {38, 65, 24, 97, 13, 76, 25, 49, 26, 27};
        showArr(arr);
        System.out.println("====================");

        int[] result = sort.sort(arr, 0, arr.length - 1);
        System.out.println("====================");
        showArr(result);
    }
}
