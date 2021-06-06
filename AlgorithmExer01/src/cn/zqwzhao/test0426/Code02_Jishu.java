package cn.zqwzhao.test0426;

/**
 *
 *
 */
public class Code02_Jishu {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,6,6,7,7,2,1,3,4,4};
        countJi(arr);
    }

    /**
     * 一个数组中有一种数出现了奇数次,其他数都出现了偶数次，
     * 怎么找到并打印这些数
     * @param arr
     */
    public static void countJi(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length;i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    /**
     * 一个数组中有2种数出现了奇数次,其他数都出现了偶数次，
     *  怎么找到并打印这些数
     */




}
