package org.example.stack;

/**
 * @author zhaoqw
 * @date 2024/12/24
 */
public interface IStack<E> {
    // 向栈顶插入元素，时间复杂度 O(1)
    void push(E e);

    // 从栈顶删除元素，时间复杂度 O(1)
    E pop();

    // 查看栈顶元素，时间复杂度 O(1)
    E peek();

    // 返回栈中的元素个数，时间复杂度 O(1)
    int size();

    boolean isEmpty();
}
