package cn.zqwzhao.basicsort;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2022-01-06 21:13]
 */
public class SelectSortDemo {
    public static void selectionSort(int [] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = 0;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }

            swap(arr,i, minIndex);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
