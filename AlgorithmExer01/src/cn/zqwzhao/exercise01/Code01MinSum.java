package cn.zqwzhao.exercise01;

/**
 * 给定一个数组, 从左到右，求出每一个元素左边比他小的数的总和
 * [6,3,2,1,6,7]
 * 结果
 * [0,0,0,0,6,18]
 * 6 左边没有比他小的 0
 * 3 同理 0
 * 2 同理 0
 * 1 同理 0
 * 6 左边有 3,2,1 比他小 总和 6
 * 7 同理得 18
 *
 * @author zhaoqw
 * @date 2022/07/07
 */
public class Code01MinSum {

  public static void process(int[] arr, int L, int R) {
    if (L == R) return;
    int mid = L + ((R - L) >> 1);
    process(arr, L, mid);
    process(arr, mid + 1, R);
    merge(arr, L, mid ,R);
  }

  private static void merge(int[] arr, int L, int mid, int R) {
    int[] help = new int[R - L + 1];
    int i = 0;
    int p1 = L;
    int p2 = mid +1;
    while (p1 <= mid && p2 <= R) {
      help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
    }

    while(p1 <= mid) {
      help[i++] = arr[p1++];
    }
    while (p2 <= mid) {
      help[i++] = arr[p2++];
    }
    for (i = 0; i < help.length; i++) {
      arr[L + i] = help[i];
    }
  }


}
