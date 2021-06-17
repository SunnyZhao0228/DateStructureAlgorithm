package cn.zqwzhao.binarysearch;

/**
 * @Auther: zhaoqw
 * @Date: 2021/6/16 - 06 - 16 - 19:30
 * @Description: cn.zqwzhao.binarysearch
 * @version: 1.0
 */
public class BinarySearchTest {



    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            //int mid = left + ((right - left) >> 1);
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        System.out.println("没有找到");
        return -1;
    }



}
