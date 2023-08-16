package org.example.array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * MyArrayList
 *
 * @author zhaoqw
 * @date 2023/7/25
 */
public class MyArrayList<E> implements List<E>, java.io.Serializable {
    private static final long serialVersionUID = 1999999999999999999L;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    transient Object[] elementData;
    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        // 如果当前数组为空，那么返回true
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        // 如果包含目标元素，则返回true
        return indexOf(o) > 0;
    }

    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override
    public Object[] toArray() {
        // 以正确的顺序（从第一个到最后一个元素）返回一个包含此列表中所有元素的数组。
        return Arrays.stream(elementData).toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // 以正确的顺序返回一个包含此列表中所有元素的数组（从第一个到最后一个元素）;
        // 返回的数组的运行时类型是指定数组的运行时类型。
        return null;
    }

    private void ensureCapacity(int capacity) {
        if (capacity < this.size) {
            return ;
        }
        Object[] newElementData = new Object[capacity];
        // elementData = Arrays.copyOf(elementData, capacity);
        for (int i = 0; i < elementData.length; i++) {
            newElementData[i] = elementData[i];
        }
        elementData = newElementData;
    }


    @Override
    public boolean add(E e) {
        // 将指定的元素追加到此列表的末尾。
        // Appends the specified element to the end of this list (optional operation).
        int oldCapacity = this.elementData.length;
        if (oldCapacity == size) {
            ensureCapacity(oldCapacity + oldCapacity >> 1);
        }
        elementData[size] = e;
        size ++;
        return true;
    }


    @Override
    public boolean remove(Object o) {
        // Removes the element at the specified element in this list (optional operation).
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (! contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addAll(size, c);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index> size) {
            throw new IndexOutOfBoundsException();
        }
        int oldLength = elementData.length;
        if (oldLength  < size + c.size()) {
            ensureCapacity(oldLength + oldLength >> 2 + c.size());
        }
        // 挪动元素
        for(int i = size + c.size() - 1; i > index + c.size(); i--) {
            this.elementData[i]  = this.elementData[i - c.size()];
        }
        for (E e : c) {
            elementData[index++] = e;
        }
        this.size += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.elementData = null;
        this.size = 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        E oldValue = (E) elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index, elementData, index, numMoved);
        }
        elementData[--size] = null; // clear to let GC do its work
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }
}
