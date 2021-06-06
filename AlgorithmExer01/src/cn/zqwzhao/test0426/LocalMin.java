package cn.zqwzhao.test0426;

import java.sql.SQLOutput;

/**
 * @Auther: zhaoqw
 * @Date: 2021/4/26 - 04 - 26 - 22:57
 * @Description: cn.zqwzhao.test0426
 * @version: 1.0
 */
public class LocalMin {

    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,4,5,6,7};
        System.out.println(getLessIndex(arr));
    }

    public static int binarySerarch(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        // L..R
        while (L < R) { // L..R 至少两个数的时候
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return mid;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return -1;
    }

}
