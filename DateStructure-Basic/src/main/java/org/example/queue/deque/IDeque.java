package org.example.queue.deque;

/**
 * 双端队列接口
 *
 * @author zhaoqw
 * @date 2025/2/14
 */
public interface IDeque<E> {
    // 从队头插入元素，时间复杂度 O(1)
    void addFirst(E e);

    // 从队尾插入元素，时间复杂度 O(1)
    void addLast(E e);

    // 从队头删除元素，时间复杂度 O(1)
    E removeFirst();

    // 从队尾删除元素，时间复杂度 O(1)
    E removeLast();

    // 查看队头元素，时间复杂度 O(1)
    E peekFirst();

    // 查看队尾元素，时间复杂度 O(1)
    E peekLast();
}
