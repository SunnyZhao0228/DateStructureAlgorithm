package exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 位运算联系体
 *
 * @Auther: zhaoqw
 * @Date: 2022/6/15
 */
public class ArrayTest01 {

    public static int printNumTimes(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            } else {
                hashMap.put(arr[i], 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return 0;
    }

    // 一堆数，只有一个数出现奇数次，找出这个数
    public static int printMaxTimesNum(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        System.out.println(eor);
        return eor;
    }

    // 一个数组中有两种数出现了奇数次，其他都出现了偶数次，怎么找到并打印这个数
    public static int[] printMaxNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        // eor = ? 它就是两个奇数相与 a^b
        // 提取eor的二进制，最右位置的1
        int rightOne = eor & (-eor);

        int eorTwo = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                eorTwo ^= arr[i];
            }
        }
        System.out.println(eorTwo + "  :  " +(eor ^ eorTwo));
        return new int[]{eor,eor^eorTwo};
    }

    /**
     * 一个数组中有1种数出现了K次，其他都出现了M次，M > 1, K<M
     * 找到并打印这个数，要求额外空间复杂度O(1),时间复杂都O(n)
     * @param arr 数组
     * @return 出现K次的数
     */
    public static int printMaxNum3(int[] arr, int k, int m) {
        int[] t = new int[32];
        // t[0]位置 代表数组元素进制0位置出现1的次数
        // t[i]位置 代表数组元素进制i位置出现1的次数
        for (int num : arr) {
            for (int i = 0; i <= 31; i++) {
                if (((num >> i) & 1) != 0) {
                    t[i] ++;
                }
                // t[i] += (arr[i] >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m == 0) {
                ans |= (1 << i);
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static int printMaxNum3X(int[] arr, int k, int m) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            } else {
                hashMap.put(arr[i], 1);
            }
        }
        Set<Integer> keySet = hashMap.keySet();
        for (Integer num : keySet) {
            if (hashMap.get(num) == k) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 产生随机数组
     *
     * @param maxKinds 最多 数的种数
     * @param range 数组范围
     * @param k 一个数出现K次
     * @param m n个数出现m次
     * @return 随机数组
     */
    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        int kTimesNum = rangeNum(range);

        int numKinds = (int) (Math.random() * maxKinds) + 2;
        // K * 1 + (numKinds - 1) * m
        int[] arr = new int[k + (numKinds - 1) * m];
        int index = 0;
        for (; index < k; index++) {
            arr[index] = kTimesNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(kTimesNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = rangeNum(range);
            }while(set.contains(curNum));
            set.add(curNum);
            numKinds --;
            for(int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            // i 位置的数，随机和j位置交换
            int j = (int)(Math.random() * arr.length);// 0 - n-1
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    /**
     * 随机生成[-range, range] 之间的一个数
     * @param range
     * @return
     */
    public static int rangeNum(int range) {
        return (int)((Math.random() * range) + 1) - (int)((Math.random() * range) + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 5, 5, 4, 6, 2, 7, 77, 1, 4, 6, 7, 4, 4, 3};
        int[] arr2 = {1, 2, 3, 4, 4, 5, 5, 4, 6, 2, 7, 77, 1, 4, 6, 7, 7, 4, 4, 3};
        printMaxTimesNum(arr);
        printNumTimes(arr);
        printMaxNum2(arr2);
        int kinds = 10;
        int range = 200;
        int testTimes = 10000;
        int max = 9;
        for (int i = 0; i < testTimes; i++) {
            int a = (int)(Math.random() * max) + 1; // 1-9
            int b = (int)(Math.random() * max) + 1;
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            if (k == m) {
                m++;
            }
            int[] array = randomArray(kinds, range, k, m);
            int ans1 = printMaxNum3X(array, k, m);
            int ans2 = printMaxNum3(array, k, m);
            if (ans1 != ans2) {
                System.out.println("测试失败");
            }
        }
        System.out.println("测试成功");
    }
}
