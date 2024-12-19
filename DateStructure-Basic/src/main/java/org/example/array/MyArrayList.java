package org.example.array;

import org.example.interfaces.AbstractList;

/**
 * @author zhaoqw
 * @date 2024/12/19
 */
public class MyArrayList<E> extends AbstractList<E> {
    private static final int DEFAULT_CAPACTITY = 10;
    /**
     * 元素集合
     */
    private E[] elements;

    public MyArrayList() {
        this(DEFAULT_CAPACTITY);
    }

    public MyArrayList(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACTITY);
        elements = (E[]) new Object[capacity];
    }

    @Override
    public void clear() {
        elements = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index ; i--) {
            elements[i] = elements[i -1];
        }
        elements[index] = element;
        size ++;
    }

    public void addLast(E element) {
        ensureCapacity(size + 1);
        elements[size ++] = element;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        trim();
        return old;
    }

    public E removeLast() {
        if (size == 0) return null;
        E old = elements[size - 1];
        elements[--size] = null;
        trim();
        return old;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }
        return 0;
    }

    // 扩容方法
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    // 缩容
    private void trim(){
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity >> 1; // 缩容为一半
        if(size > newCapacity || newCapacity <= DEFAULT_CAPACTITY) return;
        // 剩余空间很多
        E[] newElements = (E[]) new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("size=" + size + ", 从" + oldCapacity + "缩容为" + newCapacity);
    }

    @Override
    public String toString() {
        // 打印形式为: size=5, [99, 88, 77, 66, 55]
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if(0 != i) string.append(", ");
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
