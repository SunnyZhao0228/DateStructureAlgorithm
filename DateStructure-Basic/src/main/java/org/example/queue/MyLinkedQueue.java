package org.example.queue;

import java.util.LinkedList;

/**
 * @author zhaoqw
 * @date 2025/2/14
 */
public class MyLinkedQueue<E> implements IQueue<E>{

    private final LinkedList<E> linkedList = new LinkedList<>();
    @Override
    public void push(E e) {
        linkedList.addLast(e);
    }


    // 从队头删除元素，时间复杂度 O(1)
    @Override
    public E pop() {
        return linkedList.getFirst();
    }


    // 从队头获取元素，时间复杂度 O(1)
    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
