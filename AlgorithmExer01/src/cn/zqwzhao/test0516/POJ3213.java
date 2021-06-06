package cn.zqwzhao.test0516;

import java.util.Scanner;

/**
 * @Auther: zhaoqw
 * @Date: 2021/5/16 - 05 - 16 - 20:14
 * @Description: cn.zqwzhao.test0516
 * @version: 1.0
 */
public class POJ3213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == -1 ) break;
            int k = sc.nextInt();
            int m = sc.nextInt();
            int[][] a = new int[n][k];
            int[][] b = new int[k][m];
            int[][] c = new int[n][m];
            int[] B_columns = new int[k];
            int[] C_columns = new int[m];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j <a[i].length; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j <b[i].length; j++) {
                    b[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j <c[i].length; j++) {
                    c[i][j] = sc.nextInt();
                }
            }
            mult2(B_columns,C_columns,a,b,c,n,k,m);
        }




    }

    /**
     * 矩阵乘法
     * @param a
     * @param b
     * @param res
     * @return
     */
    public static  String mult(int[][] a, int[][] b, int res[][]) {
        int n = a.length;
        int x = b.length;
        int m = b[0].length;
        int[][] c = new int[a.length][b[0].length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < m; k++) {
                    c[i][k] += a[i][j] * b[j][k];
                }
            }
        }
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                if (c[i][j] != res[i][j]) {
                    System.out.println("No");
                    System.out.println((i + 1) + " " + (j + 1));
                    System.out.println(c[i][j]);
                    return "No";
                }
            }

        }
        System.out.println("Yes");
        return "Yes";
    }

    public static void  mult2(int[]  B_columns, int[] C_columns,
                              int[][] A, int[][] B, int C[][],int n,int p,int m) {

        int errorRow = 0;
        boolean flag = true;
        //A*B
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < p; j++) {
                tmp += A[i][j] * B_columns[j];
            }
            if (tmp != C_columns[i]) {
                errorRow = i;
                flag = false;
                break;
            }
        }

        if (flag == false) {
            flag = true;
            for (int i = 0; i < m; i++) {
                int tmp = 0;
                for (int j = 0; j < p; j++) {
                    tmp += A[errorRow][j] * B[j][i];
                }
                if (tmp != C[errorRow][i]) {
                    System.out.println("No");
                    System.out.printf("%d %d\n%d\n", errorRow + 1, i + 1, tmp);
                }
            }
        } else {
            System.out.println("Yes");
        }
    }





    public static int[][] generateRandomArray(int maxSize,int naxSize ,int maxValue) {
        int[][] arr = new int[maxSize][naxSize];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            }

        }
        return arr;
    }


}



