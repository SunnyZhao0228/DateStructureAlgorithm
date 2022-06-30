package cn.zqwzhao.advancesort;

/**
 * 归并排序的递归和非递归写法
 *
 * @author zhaoqw
 * @date 2022/06/30
 */
public class MergeSort {
  public static void mergeSort1(int[] arr) {
      if (arr == null || arr.length < 2) {
        return ;
      }
      process(arr, 0, arr.length - 1);
  }

  /**
   * 将arr[L...R] 上排有序
   *
   * @param arr 数组
   * @param L L位置
   * @param R R 位置
   */
  public static void process(int[] arr, int L, int R) {
    if (L == R) {
      return;
    }
    int mid = L + ((R - L) >> 1);
    process(arr, L, mid);
    process(arr, mid + 1, R);
    merge(arr, L, mid, R);
  }

  public static void merge(int[] arr, int L, int M, int R) {
    int[] help = new int[R - L + 1];
    int i = 0;
    int p1 = L;
    int p2 = M + 1;
    while (p1 <= M && p2 <= R) {
      help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
    }
    // p1 和 p2 两个肯定有一个先越界
    while (p1 <= M) {
      help[i++] = arr[p1++];
    }
    while (p2 <= R) {
      help[i++] = arr[p2++];
    }
    for (i = 0; i < help.length; i ++) {
      arr[L + i] = help[i];
    }
  }

  // 非递归方法实现
  public static void mergeSort2(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    int N = arr.length;
    // 步长
    int mergeSize = 1;
    while (mergeSize < N) { // log N
      // 当前左组的，第一个位置
      int L = 0;
      while (L < N) {
        if (mergeSize >= N - L) {
          break;
        }
        int M = L + mergeSize - 1;
        int R = M + Math.min(mergeSize, N - M - 1);
        merge(arr, L, M, R);
        L = R + 1;
      }
      // 防止溢出
      if (mergeSize > N / 2) {
        break;
      }
      mergeSize <<= 1;
    }
  }


  // for test
  public static int[] generateRandomArray(int maxSize, int maxValue) {
    int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
    }
    return arr;
  }

  // for test
  public static int[] copyArray(int[] arr) {
    if (arr == null) {
      return null;
    }
    int[] res = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      res[i] = arr[i];
    }
    return res;
  }

  // for test
  public static boolean isEqual(int[] arr1, int[] arr2) {
    if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
      return false;
    }
    if (arr1 == null && arr2 == null) {
      return true;
    }
    if (arr1.length != arr2.length) {
      return false;
    }
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }
    return true;
  }

  // for test
  public static void printArray(int[] arr) {
    if (arr == null) {
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  // for test
  public static void main(String[] args) {
    int testTime = 500000;
    int maxSize = 20;
    int maxValue = 100;
    System.out.println("测试开始");
    int[] arr1 = null;
    int[] arr2 = null;
    for (int i = 0; i < testTime; i++) {
      arr1 = generateRandomArray(maxSize, maxValue);
      arr2 = copyArray(arr1);
      mergeSort1(arr1);
      mergeSort2(arr2);
      if (!isEqual(arr1, arr2)) {
        System.out.println("出错了！");
        printArray(arr1);
        printArray(arr2);
        break;
      }
    }
    System.out.println("测试结束");
    printArray(arr1);
    printArray(arr2);
  }
}
