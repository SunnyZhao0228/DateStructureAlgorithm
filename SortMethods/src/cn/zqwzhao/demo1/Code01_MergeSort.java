package cn.zqwzhao.demo1;

/**
 * 归并排序
 * @Auther: zhaoqw
 * @Date: 2021/5/29 - 05 - 29 - 22:44
 * @Description: cn.zqwzhao.demo1
 * @version: 1.0
 */
public class Code01_MergeSort {
    public static void mergeSort1(int[] arr) {
        if (arr == null|| arr.length < 2) {
            return ;
        }

        process(arr,0,arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if(L == R) {
            return ;
        }
        int mid = L + ((R-L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++]:arr[p2++];
        }
        //要么p1越界，要么p2越界，但是其中只能有一个越界

        while(p1 <= mid) {
            help[i++] = arr[p1];
        }
        while(p2 <= R) {
            help[i++] = arr[p2];
        }
        for (int j = 0; j < arr.length; j++) {
            arr[j] = help[j];
        }
    }


    //非递归归并排序
    private static void mergeSort2(int[] arr) {
        if (arr == null|| arr.length < 2) {
            return ;
        }
        int N = arr.length;
        //一组是2倍的mergeSize，
        int mergeSize = 1; //当前有序的左组长度
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                int M = L + mergeSize - 1;
                if (M >= N) {
                    break;
                }

                int R = Math.min(M + mergeSize - 1, N - 1);
            }
        }
    }
}
