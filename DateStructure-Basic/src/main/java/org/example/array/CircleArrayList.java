package org.example.array;

/**
 * 环形数组
 *
 * @author zhaoqw
 * @date 2024/12/24
 */
public class CircleArrayList<T> {
    private static final int DEFAULT_CAPACTITY = 10;
    private T[] array;

    private int count;
    private int size;

    private int start;

    private int end;

    public CircleArrayList() {
        this(DEFAULT_CAPACTITY);
    }

    public CircleArrayList(int capacity) {
        this.size = capacity;
        this.array = capacity < DEFAULT_CAPACTITY ?
                (T[]) new Object[DEFAULT_CAPACTITY]: (T[]) new Object[capacity];
        this.start = 0;
        this.end = 0;
        this.count = 0;
    }


    private void resize(int newSize) {
        T[] newArr = (T[])new Object[newSize];
        // 复制到新数组
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[(start + i) % size];
        }
        array = newArr;
        start = 0;
        end = count;
        size = newSize;
    }

    // 在数组头部添加元素，时间复杂度 O(1)
    public void addFirst(T val) {

    }


    // 删除数组头部元素，时间复杂度 O(1)
    public void removeFirst() {
        if(isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
    }

    // 在数组尾部添加元素，时间复杂度 O(1)
    public void addLast(T val) {

    }

    // 删除数组尾部元素，时间复杂度 O(1)
    public void removeLast() {
        if(isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
    }

    public T getFirst() {
        if(isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        return array[start];
    }

    public T getLast() {
        if(isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        return array[(end - 1 + size) % size];
    }
    public boolean isFull() {
        return count == size;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
