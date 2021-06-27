package cn.zqwzhao.demo1;

/**
 * @Auther: zhaoqw
 * @Date: 2021/6/27 - 06 - 27 - 17:58
 * @Description: cn.zqwzhao.demo1
 * @version: 1.0
 */
public class Code03_QuickSort {
    public static void main(String[] args) {
        int[] arr={45,80,55,40,42,85};
        quickSort1(arr);
        printArray(arr);
    }
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);

    }

    public static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // L..R partition arr[R]  [   <=arr[R]   arr[R]    >arr[R]  ]
        int M = partition(arr, L, R);
        process1(arr, L, M - 1);
        process1(arr, M + 1, R);

    }

    public static void swap(int[] arr, int m, int n) {
       int temp = arr[m];
       arr[m] = arr[n];
       arr[n] = temp;
    }



    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + "   ");
        }
        System.out.println();
    }

}
