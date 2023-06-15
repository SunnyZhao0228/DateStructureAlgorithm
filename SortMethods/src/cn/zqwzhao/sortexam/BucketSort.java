package cn.zqwzhao.sortexam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 桶排序
 *
 * @author zhaoqw
 * @date 2023/01/29
 */
public class BucketSort  {
    /**
     * 排序100万个0-99之间的数字，排序算法怎么选？
     * @param A
     * @return
     */
    public List<Integer> sort(List<Integer> A) {
        int k = 100;
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new LinkedList<>());
        }
        // 利用索引，item % 100 获取到索引位置，得到列表插入进去
        for (Integer item : A) {
            buckets.get(item % 100).add(item);
        }
        for (LinkedList<Integer> bucket : buckets) {
            list.addAll(bucket);
        }
        return list;
    }
}
