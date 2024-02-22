package org.example.heap;

/**
 * @author zhaoqw
 * @date 2024/2/22
 */
public class Heap implements IHeap {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    private Object[] array;

    /**
     * array容量
     */
    private int size = 0;

    /**
     * 已存的元素个数
     */
    private int count;

    public Heap() {
        array = new Object[DEFAULT_INITIAL_CAPACITY];
        this.size = DEFAULT_INITIAL_CAPACITY - 1;
        this.count = 0;
    }

    public Heap(int capacity) {
        array = new Object[capacity + 1];
        this.size = capacity;
        this.count = 0;
    }

    @Override
    public boolean add(Object data) {
        if (data == null) {
            throw new NullPointerException();
        }
        if (count > size) { // 满了
            return false;
        }
        ++count;
        array[count] = data;
        int i = count;
        while (i / 2 > 0 && compareTo(array[i], array[i / 2])) {
            Object temp = array[i];
            array[i] = array[i / 2];
            array[i / 2] = temp;
            i = i / 2;
        }
        return true;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    public boolean compareTo(Object firstElement, Object secondElement) {
        throw new RuntimeException("未实现 compareTo 方法");
    }
}
