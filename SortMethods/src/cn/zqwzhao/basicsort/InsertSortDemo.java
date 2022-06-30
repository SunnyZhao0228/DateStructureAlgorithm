package cn.zqwzhao.basicsort;

import java.util.Arrays;

/**
 * @author zhaoqw
 * @date 2022/06/30
 */
public class InsertSortDemo {
  /**
   * 插入排序
   *
   * @param arr 数组
   */
  public static void insertSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    for (int i = 1; i < arr.length; i++) {
      for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    }
  }

  /**
   * 希尔排序实现
   *
   * @param arr 数组
   */
  public static void shellSort(int[] arr) {
    //增量gap，并逐步缩小增量
    for (int gap = arr.length / 2; gap > 0; gap /= 2) {
      //从第gap个元素，逐个对其所在组进行直接插入排序操作
      for (int i = gap; i < arr.length; i++) {
        int j = i;
        while (j - gap >= 0 && arr[j] < arr[j - gap]) {
          //插入排序采用交换法
          int temp = arr[j];
          arr[j] = arr[j - gap];
          arr[j - gap] = temp;
          j -= gap;
        }
      }
    }
  }

  // for test
  public static void comparator(int[] arr) {
    Arrays.sort(arr);
  }

  // for test
  public static int[] generateRandomArray(int maxSize, int maxValue) {
    // Math.random() -> [0,1) 所有的小数，等概率返回一个
    // Math.random() * N -> [0,N) 所有小数，等概率返回一个
    // (int)(Math.random() * N) -> [0,N-1] 所有的整数，等概率返回一个
    int[] arr = new int[(int) ((maxSize + 1) * Math.random())]; // 长度随机
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
    int maxSize = 20; // 随机数组的长度0～100
    int maxValue = 100;// 值：-100～100
    boolean succeed = true;
    for (int i = 0; i < testTime; i++) {
      int[] arr = generateRandomArray(maxSize, maxValue);
      int[] arr1 = copyArray(arr);
      int[] arr2 = copyArray(arr);
      shellSort(arr1);
      comparator(arr2);
      if (!isEqual(arr1, arr2)) {
        // 打印arr1
        // 打印arr2
        succeed = false;
        for (int j = 0; j < arr.length; j++) {
          System.out.print(arr[j] + " ");
        }
        System.out.println();
        break;
      }
    }
    System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    int[] arr = generateRandomArray(maxSize, maxValue);
    printArray(arr);
    shellSort(arr);
    printArray(arr);
  }
}
