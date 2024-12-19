package org.example.interfaces;

/**
 * @author zhaoqw
 * @date 2024/12/19
 */
public abstract class AbstractList<E> implements List<E> {
    protected int size;

    // 下标越界抛出的异常
    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    // 检查下表越界
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }
    protected void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}

    // 检查是否为空
    protected void checkEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }
}
