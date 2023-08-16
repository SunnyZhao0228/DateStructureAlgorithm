package org.example.linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 模拟实现带头结点的非循环单链表。
 * MyLinkedList实现List的大部分功能
 * @author zhaoqw
 * @date 2023/7/25
 */
public class MyLinkedList<E> implements List<E>, Iterable<E> {
    private Node<E> head;

    /**
     * 节点
     *
     * @param <E>
     */
    public static class Node<E> {
        private E value;
        private Node<E> next;

        public Node() {
            this.next = null;
        }
        public Node(E value) {
            this.value = value;
            this.next = null;
        }
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public MyLinkedList() {
        this.head = new Node<>();
    }

    public MyLinkedList(Node<E> head) {
        this.head = head;
    }

    /**
     * 集合转换成 MyLinkedList
     * @param collection 集合
     */
    public MyLinkedList(Collection<? extends E> collection) {
        this();
        Node<E> p = head;
        for (E e : collection) {
            Node<E> temp = new Node<>(e, p.next);
            p.next = temp;
            p = p.next;
        }
    }

    @Override
    public int size() {
        int count = 0;
        Node<E> p = head;
        while (p.next != null) {
            count ++;
            p = p.next;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 如果此列表包含指定的元素，则返回 true
     * @param o element whose presence in this list is to be tested
     * @return
     */
    @Override
    public boolean contains(Object o) {
        Node<E> p = head;
        while (p.next != null) {
            if (p.value.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> p = head;
            @Override
            public boolean hasNext() {
                return head.next != null;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        Node<E> p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node<>(e, null);
        return true;
    }

    /**
     * 头插法
     *
     * @param e 元素
     */
    public void addToHead(E e) {
        Node<E> p = head;
        Node<E> newNode = new Node<>(e, null);
        p.next = newNode;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> cur = head;
        while (cur.next != null && !cur.next.value.equals(o)) {
            cur = cur.next;
        }
        if (cur.next == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (! this.contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
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
        head.next = null;
    }

    @Override
    public E get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> p = head.next;
        int i = 0;
        while (p != null && i < index) {
            p = p.next;
            i++;
        }
        if (p == null) {
            throw new IndexOutOfBoundsException();
        }
        return p.value;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> p = head.next;
        int i = 0;
        while (p != null && i < index) {
            p = p.next;
            i++;
        }
        if (p == null) {
            throw new IndexOutOfBoundsException();
        }
        E oldValue = p.value;
        p.value = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> p = head;
        int i = 0;
        while (p.next != null && i < index) {
            p = p.next;
            i++;
        }
        if (p.next == null) {
            if (i == index) {
                Node<E> newNode = new Node<>(element, p.next);
                p.next = newNode;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        Node<E> newNode = new Node<>(element, p.next);
        p.next = newNode;
    }

    @Override
    public E remove(int index) {
        return null;
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
        String string = "[";
        Node<E> p = head;
        if (p.next != null) {
            while (p.next.next != null) {
                p = p.next;
                string = string + p.value + ", ";
            }
            string = string + p.next.value + "]";
        } else {
            string = string + "]";
        }
        return string;
    }
}
