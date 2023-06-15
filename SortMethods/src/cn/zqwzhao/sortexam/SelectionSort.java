package cn.zqwzhao.sortexam;

import java.util.Random;

/**
 * @author zhaoqw
 * @date 2023/01/29
 */
public class SelectionSort implements IMutableSorter {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            Helper.swap(arr, minIndex, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + "   ");
        }
        System.out.println();
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
    }
}
