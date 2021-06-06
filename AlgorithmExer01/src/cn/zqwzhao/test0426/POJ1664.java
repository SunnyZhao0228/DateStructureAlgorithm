package cn.zqwzhao.test0426;

import java.util.Scanner;

/**
 *
     POJ1664—放苹果 时间限制：1000ms，空间限制：10000K。
     问题描述：把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法（用k表示）？注意5，1，1和1，5，1 是同一种分法。
     输入格式：第一行是测试数据的数目t（0≤t≤20）。以下每行均包含两个整数m和n，以空格分开，1≤m，n≤10。
     输出格式：对输入的每组数据m和n，用一行输出相应的k。
 * @Auther: zhaoqw
 * @Date: 2021/5/5 - 05 - 05 - 17:31
 * @Description: cn.zqwzhao.test0505
 * @version: 1.0
 */
public class POJ1664 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(apple(m, n));
        }



    }

    /**
     * 苹果分为两种情况，一种是有盘子为空，一种是每个盘子上都有苹果
     * 1.假设有一个盘子为空，则(m,n)问题转化为将m个苹果放在n-1个盘子上，即求得(m,n-1)即可
     * 2.假设所有盘子都装有苹果，则每个盘子上至少有一个苹果，即最多剩下m-n个苹果，问题转化为将m-n个苹果放到n个盘子上
     * 即求(m-n，n)
     * @param m
     * @param n
     */
    public static int apple(int m,int n) {

        if(m < 0 || n < 0) {
            return 0;
        }else if(m == 1 || n == 1){
            return 1;
        }else {
            return apple(m,n - 1) + apple(m - n , n);
        }

    }
}
