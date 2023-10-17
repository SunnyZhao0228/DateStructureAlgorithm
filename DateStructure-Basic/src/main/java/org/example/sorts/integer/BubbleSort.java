package org.example.sorts.integer;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author zhaoqw
 * @date 2023/01/29
 */
public class BubbleSort implements IntegerSorter {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Helper.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int maxCount = 1000;
        int maxValue = 10000;
        int[] ints = Helper.generateRandomArray(maxCount, maxValue);
        int[] ints1 = Helper.copyArray(ints);
        Arrays.sort(ints);
        new BubbleSort().sort(ints1);
        boolean equal = Helper.isEqual(ints, ints1);
        System.out.println("结果" + equal);

    }
}