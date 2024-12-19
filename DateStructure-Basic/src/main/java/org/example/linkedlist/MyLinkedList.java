package org.example.linkedlist;

import org.example.interfaces.AbstractList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author zhaoqw
 * @date 2024/12/19
 */
public class MyLinkedList<E> extends AbstractList<E> {

    @Override
    public void clear() {
        size = 0;
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
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    private class Node<E> {
        E element;

        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
