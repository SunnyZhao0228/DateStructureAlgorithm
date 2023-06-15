package cn.zqwzhao.sortexam;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zhaoqw
 * @date 2023/01/29
 */
public class MergeSort implements IMutableSorter {
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    private void mergeSort(int[] arr, int L, int R) {
        if ((R - L) <= 1) {
            return;
        }
        // 0 + (3 - 0 + 1) / 2 = 2
        int mid = (L + R + 1) / 2;
        mergeSort(arr, L, mid);
        mergeSort(arr, mid, R);
        merge(arr, L, mid, R);
    }

    private void merge(int[] arr, int L, int mid, int R) {
        int[] A = Arrays.copyOfRange(arr, L, mid + 1);
        // 注意这个方法超出数组边界，新数组自动补0
        int[] B = Arrays.copyOfRange(arr, mid, R + 1);
        // 添加哨兵
        A[A.length - 1] = B[B.length - 1] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = L; k < R; k++) {
            if (A[i] < B[j]) {
                arr[k] = A[i++];
            } else {
                arr[k] = B[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + "   ");
        }
        long start = System.currentTimeMillis();
        System.out.println();
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        System.out.println(System.currentTimeMillis() - start);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
    }
}
