package org.example.stack;

/**
 * @author zhaoqw
 * @date 2023/11/6
 */
public class StackBasedOnLinkedList {
    private Node top = null;

    public int pop() {
        if (top == null) return -1;
        int temp = top.getData();
        top = top.next;
        return temp;
    }

    public void push(Integer value) {
        Node newNode = new Node(value, null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public void printAll() {
        Node p = top;
        while(p != null) {
            int value = p.getData();
            System.out.print(value + "   ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
