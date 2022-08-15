package cn.zqwzhao.advancesort;

/**
 * 小和问题
 *
 * 在一个数组中，一个数左边比它小的数的总和，叫该数的小和
 * 所有数的小和累加起来，叫数组小和
 * 例子： [1,3,4,2,5]
 * 1左边比1小的数：没有
 * 3左边比3小的数：1
 * 4左边比4小的数：1、3
 * 2左边比2小的数：1
 * 5左边比5小的数：1、3、4、 2
 * 所以数组的小和为1+1+3+1+1+3+4+2=16
 * 给定一个数组arr，求数组小和
 * @author zhaoqw
 * @date 2022/8/9
 */
public class SmallSumQuestion {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,5};
        int i = smallSum(arr);
        System.out.println(i);
    }

    /**
     * O(n^2) method
     * @param arr arr
     * @return 小和
     */
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length == 1) {
            return 0;
        }

        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                sum += arr[i] > arr[j] ? arr[j] : 0;
            }
        }
        return sum;
    }
}
