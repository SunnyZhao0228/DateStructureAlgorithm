package org.example.sorts;

/**
 * 插入排序
 *
 * @author zhaoqw
 * @date 2023/7/28
 */
public class InsertionSort implements IntegerSorter{
    @Override
    public void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            // 将A[i] 插入在卡片0，到卡片i之间
            // j代表抓到的牌，先放到最右侧，不断交换到对应的位置
            int c = arr[i];
            int j = i;

            for(; j > 0 && arr[j-1] > c;j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = c;
        }
    }
}
