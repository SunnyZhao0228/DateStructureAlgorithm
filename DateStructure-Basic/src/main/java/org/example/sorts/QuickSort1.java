package org.example.sorts;

/**
 * @author zhaoqw
 * @date 2023/01/31
 */
public class QuickSort1 implements IntegerSorter {
    @Override
    public void sort(int[] arr) {

    }

    private void quickSort(int[] A, int l ,int r) {
        if (r - l <= 1) {
            return ;
        }
        // 选择最左边的元素构造子问题集合
        // 小于X的放左边 大于X的放右边
        // int x = A[l];
        int i = partition(A, l, r);
        // i 代表x的位置
        quickSort(A, l, i);
        quickSort(A, i + 1, r);
    }

    private int partition(int[] A, int l ,int r) {
        int x = A[l];
        int i = l + 1;
        int j = r;
        // | ----left ----| mid | ----right----|
        while (i != j) {
            if (A[i] < x) {
                i++;
            } else {
                Helper.swap(A, i, j--);
            }
        }
        Helper.swap(A, i - 1, j);
        return i - 1;
    }
}
