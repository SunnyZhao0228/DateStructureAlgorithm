package cn.zqwzhao.test0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @Auther: zhaoqw
 * @Date: 2021/5/16 - 05 - 16 - 23:10
 * @Description: cn.zqwzhao.test0516
 * @version: 1.0
 */
public class POJ3213_1{
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = sc.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int p = Integer.parseInt(strings[1]);
        int m = Integer.parseInt(strings[2]);
        int[][] a = new int[n][p];
        for (int i = 0; i < n; i++) {
            strings = sc.readLine().split(" ");
            for (int j = 0; j < p; j++) {
                a[i][j] = Integer.parseInt(strings[j]);
            }
        }
        int[][] b = new int[p][m];
        for (int i = 0; i < p; i++) {
            strings = sc.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                b[i][j] = Integer.parseInt(strings[j]);
            }
        }
        int[][] c = new int[n][m];
        for (int i = 0; i < n; i++){
            strings = sc.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                c[i][j] = Integer.parseInt(strings[j]);
            }
        }
        int result;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                result=0;
                for (int k = 0; k < p; k++) {
                    result += a[i][k] * b[k][j];
                }
                if (result != c[i][j]) {
                    System.out.println("No");
                    System.out.println((i + 1) + " " + (j + 1));
                    System.out.println(result);
                    return;
                }
            }
        }
        System.out.println("Yes");
    }

}
