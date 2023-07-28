package org.example.sorts;

import java.util.HashSet;
import java.util.List;

/**
 * 实际业务里面写排序的话
 * 正常来说是先定义结构，然后去实现相应方法
 *
 *
 */
public interface ISorter<T> {

    /**
     * 给List排序
     * @param list List
     * @return 排序结果
     */
    List<T> sort(List<T> list);

    /**
     * 给HashSet的元素排序
     *
     * @param hashSet hashSet
     * @return 排序结果
     */
    List<T> sort(HashSet<T> hashSet);
}
