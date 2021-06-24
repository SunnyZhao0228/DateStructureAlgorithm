package cn.zqwzhao.recursiontest01;

/**
 * 连续字符 ： 统计一个字符串中连续相同字符最长的字符
 * @Auther: zhaoqw
 * @Date: 2021/6/19 - 06 - 19 - 19:45
 * @Description: cn.zqwzhao.recursiontest01
 * @version: 1.0
 */
public class Leetcode1446 {
    public static void main(String[] args) {
        String str = "aabbcccddddeeefffffgg";
        System.out.println(maxPower(str));
    }

    public static int maxPower(String s) {
        char[] chars = s.toCharArray();
        int count = 1, max = 0;
        for (int i = 1; i < chars.length; i++) {
            //count满足条件+1，不满足条件回到 1
            count += chars[i] == chars[i - 1] ? 1 : -count + 1;
            max = Math.max(max, count);
        }
        return Math.max(max, count);
    }


}
