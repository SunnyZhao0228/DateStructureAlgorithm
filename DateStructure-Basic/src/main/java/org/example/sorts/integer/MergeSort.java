package org.example.sorts.integer;

import org.example.sorts.integer.IntegerSorter;

/**
 * @author zhaoqw
 * @date 2023/7/28
 */
public class MergeSort implements IntegerSorter {
    @Override
    public void sort(int[] arr) {
        if (arr == null|| arr.length < 2) {
            return ;
        }

        process(arr,0,arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if(L == R) {
            return ;
        }
        int mid = L + ((R-L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++]:arr[p2++];
        }
        //要么p1越界，要么p2越界，但是其中只能有一个越界
        while(p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while(p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < arr.length; j++) {
            arr[j] = help[j];
        }
    }


    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        // 步长
        int mergeSize = 1;
        while (mergeSize < N) { // log N
            // 当前左组的，第一个位置
            int L = 0;
            while (L < N) {
                int M = L + mergeSize - 1;
                int R = M + Math.min(mergeSize, N - M - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            // 防止溢出
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

}
