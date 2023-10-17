package org.example.search;

/**
 * @author zhaoqw
 * @date 2023/10/17
 */
public class BinarySearch {
    private static final int SWITCH_TO_BRUTE_FORCE = 200;

    private static int[] sorted = null;


    /**
     * 在Array中查找value
     *
     * @param value 需要查找的值
     * @param array 数组
     * @param optimize 是否优化查询
     * @return value的下标
     */
    public static final int find(int value, int[] array, boolean optimize) {
        BinarySearch.sorted = array;
        try {
            return recursiveFind(value, 0, BinarySearch.sorted.length - 1, optimize);
        } finally {
            BinarySearch.sorted = null;
        }
    }

    private static int recursiveFind(int value, int start, int end, boolean optimize) {
        if (start == end) {
            int lastValue = sorted[start];
            if (value == lastValue)
                return start;
            return Integer.MAX_VALUE;
        }

        final int low = start;
        final int high = end + 1;
        final int middle = low + ((high - low) / 2);
        
        final int middleValue = sorted[middle];
        if (value == middleValue) {
            return middle;
        }
        if (value > middleValue) {
            if (optimize && (end - middle) <= SWITCH_TO_BRUTE_FORCE) {
                linearSearch(value, middle + 1, end);
            }
            recursiveFind(value, middle + 1, end, optimize);
        }
        if (optimize && (middle - start) <= SWITCH_TO_BRUTE_FORCE) {
            linearSearch(value, start, middle - 1);
        }
        recursiveFind(value,  start, middle - 1, optimize);

        return Integer.MAX_VALUE;
    }


    private static final int linearSearch(int value, int start, int end) {
        // From index i = start to i = end check if value matches sorted[i]
        for (int i = start; i <= end; i++) {
            int iValue = sorted[i];
            if (value == iValue)
                return i;
        }
        return Integer.MAX_VALUE;
    }
}
