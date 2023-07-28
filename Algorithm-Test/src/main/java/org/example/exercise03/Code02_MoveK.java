package org.example.exercise03;

/**
 *
 * 5、设计一个算法，将含有n个整型元素的数组a[0..n-1]
 * 中所有元素循环后移m位（后面的元素移动到数组的最前面)，要求算法的空间复杂度为0(1)。
 * @Auther: zhaoqw
 * @Date: 2021/6/24 - 06 - 24 - 23:44
 * @Description: cn.zqwzhao.demo1
 * @version: 1.0
 */
public class Code02_MoveK {
    public static void main(String[] args) {
        int[] arr={22,33,44,55,66,77,88,99};
        moveKbit(arr,4);
    }

    public static void moveKbit(int[] arr,int k){
        int t;
        for (int i = 0; i < k; i++) {
            t = arr[arr.length - 1];
            for (int j = arr.length - 1; j >= 1; j--)
                arr[j] = arr[j - 1];
            arr[0] = t;
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}