package cn.zqwzhao.binarysearch;

import java.util.Arrays;

/**
 * 二分查找算法
 * 最经典二分法
 * 变体：
 * 查找第一个值等于给定值的元素
 * 查找最后一个值等于给定值的元素
 * 查找第一个大于等于给定值的元素
 * 查找最后一个小于等于给定值的元素
 * <p>
 * 思考题：
 * LeetCode 33题
 *
 * @Auther: zhaoqw
 * @Date: 2021/6/16
 */
public class BinarySearchTest {

    /**
     * 传统二分法
     *
     * @param nums
     * @param target
     * @return
     */
    static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            //int mid = (right + left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        // 没找到
        return -1;
    }


    /**
     * 数组默认从小到大排序
     * <p>
     * == target 最左边位置
     * 查找第一个值等于给定值的元素
     *
     * @param nums
     * @param target
     * @return
     */
    static int mostLeftEqualNum(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) return mid;
                else right = mid - 1;
            }
        }

        return -1;

    }

    /**
     * == target 最右边边位置
     * 查找最后一个值等于给定值的元素
     *
     * @param nums
     * @param target
     * @return
     */
    static int mostRightEqualNum(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if ((mid == nums.length - 1) || nums[mid + 1] != target)
                    return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * >= target 最左边位置
     * 查找第一个大于等于给定值的元素
     *
     * @param nums
     * @param target
     * @return
     */
    static int mostLeftNoLessNum(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) return mid;
                else high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //查找最后一个小于等于给定值的元素 <=target
    static int mostRightLessEqualNum(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] < target) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    // >= target 最左边位置
    public static int test1(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test1(arr, value) != mostLeftNoLessNum(arr, value)) {
                printArray(arr);
                System.out.println(value);
                System.out.println(test1(arr, value));
                System.out.println(mostLeftNoLessNum(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    /**
     * 前提：数组无序，而且相邻的数不相等
     * 求数组start到end之间的一个局部最小值
     *
     * @return
     */
    static int localMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int N = nums.length;
        if (nums.length == 1) return 0;
        if (nums[0] < nums[1]) return 0;
        if (nums[N - 1] < nums[N - 2]) return N - 1;

        int L = 0;
        int R = nums.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                ans = mid;
                break;
            }
            if (nums[mid] > nums[mid - 1]) {
                R = mid - 1;
                continue;
            }
            if (nums[mid] > nums[mid + 1]) {
                L = mid + 1;
                continue;
            }
        }

        return ans;
    }


    /**
     * 顺序查找
     *
     * @param nums
     * @param target
     * @return
     */
    static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) return i;
        }
        System.out.println("没有找到");
        return -1;
    }
}
