package cn.zqwzhao.test0426;

import java.util.Scanner;

/**
 * @Auther: zhaoqw
 * @Date: 2021/4/26 - 04 - 26 - 19:51
 * @Description: cn.zqwzhao.test0426
 * @version: 1.0
 */
public class HDU1020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str;
        for (int i = 0; i < n; i++) {
            str = sc.next();
            encoding(str);
        }
    }

    public static void encoding(String str) {

        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int m = 1;
        for (int i = 0; i <= chars.length - 1; i++) {
            if((i != chars.length - 1) &&  chars[i] == chars[i + 1]) {
                m ++;
            }else{
                if(m > 1) {
                    sb.append(m);
                }
                sb.append(chars[i]);
                m = 1;
            }
        }
        System.out.println(sb.toString());
    }
}
