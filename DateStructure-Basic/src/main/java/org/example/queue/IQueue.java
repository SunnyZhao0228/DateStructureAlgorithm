package org.example.queue;

/**
 * @author zhaoqw
 * @date 2025/2/14
 */
public interface IQueue<E> {
    // 向队尾插入元素，时间复杂度 O(1)
    void push(E e);

    // 从队头删除元素，时间复杂度 O(1)
    E pop();

    // 查看队头元素，时间复杂度 O(1)
    E peek();

    // 返回队列中的元素个数，时间复杂度 O(1)
    int size();

    boolean isEmpty();
}
