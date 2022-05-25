package basic.exercise01;

import java.util.Arrays;

/**
 * @author [zqwzh]
 * @createTime [2022-05-24]
 */
public class Code02RandToRand {
    public static void main(String[] args) {
        int testTimes = 1000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (f2() == 0) count++;
        }
        System.out.println((double) count / (double) testTimes);

        int[] counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int num = f3();
            counts[num]++;
        }
        System.out.println(Arrays.toString(counts));
    }

    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    // 等概率返回0和1
    public static int f2() {
        int ans;
        do {
            ans = f1();
        } while (ans == 3);
        return ans > 3 ? 1 : 0;
    }

    /**
     * 得到000 到111等概率
     *
     * @return
     */
    public static int f3() {
        int ans = (f2() << 2) + (f2() << 1) + (f2() << 0);
        return ans;
    }

    /**
     * 得到 0-6等概率返回
     * @return
     */
    public static int f4() {
        int ans;
        do{
            ans = (f2() << 2) + (f2() << 1) + (f2() << 0);
        }while (ans == 7);
        return ans;
    }

    public static int f5() {
        return f4() + 1;
    }
}
