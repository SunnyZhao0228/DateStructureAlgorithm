package org.example.linkedlist;

import org.example.interfaces.AbstractList;

/**
 * 双向链表
 *
 * @author zhaoqw
 * @date 2024/12/19
 */
public class MyLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {
        Node<E> sentinel = new Node<>(null);
        this.first = sentinel;
        this.last = sentinel;
        this.size = 0;
    }

    @Override
    public void clear() {
        size = 0;
        first = last = new Node<>(null);
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    /**
     * 更具索引找到某个节点
     *
     * @param index 索引
     * @return 某节点
     */

    public Node<E> node(int index) {
        rangeCheck(index);
        if (index < (size >> 1)) {
            Node<E> node = first; // 从头往后找
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
        Node<E> node = last; // 从尾往前找
        for (int i = size - 1; i > index ; i--) {
            node = node.prev;
        }
        return node;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldValue = node.element;
        node.element = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size) { // 尾插
            Node<E> oldLast = last;
            last = new Node<>(element, oldLast, null);
            oldLast.next = last;
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> eNode = new Node<>(element, prev, next);
            next.prev = eNode;
            if (prev == null) { // pre为null 说明是头插
                first = eNode;
            } else {
                prev.next = eNode;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) { // 删除头节点
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) { // 删除尾节点
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    private static class Node<E> {
        E element;

        Node<E> prev; // 指向前驱
        Node<E> next; // 指向后继

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(element);
        }
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[size=").append(size).append(", ");
        Node<E> node = first.next; // 从 first.next 开始，避免输出空节点
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(node);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
