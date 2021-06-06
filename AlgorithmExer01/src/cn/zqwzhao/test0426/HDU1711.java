package cn.zqwzhao.test0426;

import java.util.Scanner;

/**
 * @Auther: zhaoqw
 * @Date: 2021/4/26 - 04 - 26 - 20:51
 * @Description: cn.zqwzhao.test0426
 * @version: 1.0
 */
public class HDU1711 {
    public static int getIndexOf(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < 1 || s1.length() < s2.length()) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int x = 0;
        int y = 0;
        // O(M) m <= n
        int[] next = getNextArray(str2);
        // O(N)
        while (x < str1.length && y < str2.length) {
            if (str1[x] == str2[y]) {
                x++;
                y++;
            } else if (next[y] == -1) { // y == 0
                x++;
            } else {
                y = next[y];
            }
        }
        return y == str2.length ? x - y : -1;
    }

    public static int[] getNextArray(char[] str2) {
        if (str2.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2; // 目前在哪个位置上求next数组的值
        int cn = 0; // 当前是哪个位置的值再和i-1位置的字符比较
        while (i < next.length) {
            if (str2[i - 1] == str2[cn]) { // 配成功的时候
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int len1 = sc.nextInt();
            int len2 = sc.nextInt();

            char[] ans1 = new char[len1];
            for (int j = 0; j < ans1.length; j++) {
                ans1[j] = (char) (sc.nextInt() + '0');
            }

            char[] ans2 = new char[len2];
            for (int j = 0; j < ans2.length; j++) {
                ans2[j] = (char) (sc.nextInt() + '0');
            }

            int index = getIndexOf(String.valueOf(ans1),(String.valueOf(ans2)));
            if (index == -1) System.out.println(-1);
            else System.out.println(index + 1);
        }
    }
}
