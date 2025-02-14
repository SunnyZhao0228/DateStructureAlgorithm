package org.example.stack;

import java.util.LinkedList;

/**
 * @author zhaoqw
 * @date 2024/12/24
 */
public class MyLinkedStack<E> implements IStack<E> {
    private final LinkedList<E> linkedList = new LinkedList<>();

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
