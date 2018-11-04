package com.demo.Sort;

/*
* 插入排序 
* 从第一个元素开始，该元素可以认为已经被排序 
* 取出下一个元素，在已经排序的元素序列中从后向前扫描
* 如果该元素（已排序）大于新元素，将该元素移到下一位置
* 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
* 将新元素插入到该位置中
* 重复步骤2
* @param numbers 待排序数组
*/

public class InsertSort extends Sort {
    @Override
    public int[] sort(int[] numbers) {
        int temp = 0;
        // 这种写法能每次交换都能减少一次
        /*int m = 0;
        int tmp = 0;
        for (int i = 1; i < numbers.length; i++) {
            tmp = numbers[i];
            for (m = i; m > 0; m--) {
                if (tmp < numbers[m - 1]) {
                    numbers[m] = numbers[m - 1];
                } else break;
            }
            numbers[m] = tmp;
            showArr(numbers);
        }*/
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                } else break;
            }
            showArr(numbers);
        }
        return numbers;
    }

    public static void main(String[] args) {
        Sort sort = new InsertSort();
        int[] arr = {49, 38, 65, 97, 76, 13, 27};
        showArr(arr);
        System.out.println("====================");

        int[] result = sort.sort(arr);
        System.out.println("====================");
        showArr(result);
    }
}
