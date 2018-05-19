package com.demo.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeapSort extends Sort {
    /**
     * 初始化构建堆
     *
     * @param data
     */
    private void buildMaxHeap(int[] data) {
        //根据最后一个元素获取，开始调整的位置
        int startIndex = getParentIndex(data.length - 1);
        System.out.println(data[startIndex]);
        //反复进行调整
        for (int i = startIndex; i >= 0; i--) {
            maxHeap(data, data.length, i);
            showArr(data);
        }
    }

    /**
     * 此调整为从上到下调整，直到节点超出范围
     *
     * @param data
     * @param heapSize
     * @param index
     */
    private void maxHeap(int[] data, int heapSize, int index) {
        //取得当前节点的左右节点，当前节点为index
        int left = getChildLeftIndex(index);
        int right = getChildRightIndex(index);
        //对左右节点和当前节点进行比较
        int largest = index;
        if (left < heapSize && data[index] < data[left]) {
            largest = left;
        }
        if (right < heapSize && data[largest] < data[right]) {
            largest = right;
        }
        //交换位置
        if (largest != index) {
            int temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            maxHeap(data, heapSize, largest);
        }
    }

    /**
     * 排序操作
     *
     * @param data
     */
    @Override
    public int[] sort(int[] data, int... args) {
        //每次循环都能取到一个最大值，该值为根节点
        for (int i = data.length - 1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            //每次调整都是从根节点开始i不断减小，保证前一次最大节点不会参与到调整堆
            maxHeap(data, i, 0);
        }
        return data;
    }

    /**
     * 获取父节点的位置
     *
     * @param current
     */
    private int getParentIndex(int current) {
        return (current - 1) >> 1;
    }

    /**
     * 获得左子节点的位置
     *
     * @param current
     */
    private int getChildLeftIndex(int current) {
        return (current << 1) + 1;
    }

    /**
     * 获得右子节点的位置
     *
     * @param current
     */
    private int getChildRightIndex(int current) {
        return (current << 1) + 2;
    }

    class Obj {
        String name;
        String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }

    public static void main(String[] args) throws Exception {

        HeapSort sort = new HeapSort();
        String[] sortArr = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        int[] arr = {49, 38, 27, 65, 97, 13, 76};
        showArr(arr);
        System.out.println("====================");
        sort.buildMaxHeap(arr);
//        sort.maxHeap(arr, arr.length - 1, 0);
        sort.sort(arr);
        System.out.println("====================");
        showArr(arr);
    }
}



