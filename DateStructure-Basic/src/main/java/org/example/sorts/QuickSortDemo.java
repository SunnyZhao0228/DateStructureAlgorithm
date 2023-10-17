package org.example.sorts;

import java.util.Random;

/**
 * Quicksort is a sorting algorithm which, on average, makes O(n*log n) comparisons to sort
 * n items. In the worst case, it makes O(n^2) comparisons, though this behavior is
 * rare. Quicksort is often faster in practice than other algorithms.
 * <p>
 * Family: Divide and conquer.<br> 分治法
 * Space: In-place.<br> 内部排序
 * Stable: False.<br>   不稳定
 * <p>
 * Average case = O(n*log n) <br>
 * Worst case = O(n^2) <br>
 * Best case = O(n) [three-way partition and equal keys]<br>
 * <p>
 * @author zhaoqw
 * @date 2023/10/10
 */
public class QuickSortDemo<T extends Comparable<T>>{
    private static final Random RANDOM = new Random();

    public static enum PIVOT_TYPE {
        FIRST, MIDDLE, RANDOM
    }

    public static PIVOT_TYPE type = PIVOT_TYPE.RANDOM;

    public QuickSortDemo() {
    }

    public static <T extends Comparable<T>> T[] sort(PIVOT_TYPE pivotType, T[] unsorted) {
        int pivot = 0;
        if (pivotType == PIVOT_TYPE.MIDDLE) {
            pivot = unsorted.length/2;
        } else if (pivotType == PIVOT_TYPE.RANDOM) {
            pivot = getRandom(unsorted.length);
        }
        sort(pivot, 0, unsorted.length - 1, unsorted);
        return null;
    }

    private static <T extends Comparable<T>> void sort(int pivot, int start, int end, T[] unsorted) {

    }


    public static final int getRandom(int length) {
        if (type == PIVOT_TYPE.RANDOM && length > 0)
            return RANDOM.nextInt(length);
        if (type == PIVOT_TYPE.FIRST && length > 0)
            return 0;
        return length / 2;
    }

    public static <T extends Comparable<T>> void swap(int index1, int index2, T[] unsorted) {
        T temp = unsorted[index1];
        unsorted[index1] = unsorted[index2];
        unsorted[index2] = temp;
    }
}
