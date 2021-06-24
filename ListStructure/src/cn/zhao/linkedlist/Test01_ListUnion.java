package cn.zhao.linkedlist;

import java.util.ArrayList;

/**
 * @Auther: zhaoqw
 * @Date: 2021/6/19 - 06 - 19 - 20:52
 * @Description: cn.zhao.linkedlist
 * @version: 1.0
 */
public class Test01_ListUnion {
    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            value = data;
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        node2.next = null;
        node1.next = node2;
        head.next = node1;

        Node node3 = new Node(5);
        Node node4 = new Node(1);
        Node node5 = new Node(4);
        Node node6 = new Node(2);
        node6.next = null;
        node5.next = node6;
        node4.next = node5;
        node3.next = node4;

        Node node = unionList(head, node3);
        while (node.next != null) {
            node = node.next;
            System.out.println(node.value);

        }

    }

    public static  Node unionList(Node l1, Node l2) {
        Node dummyHead = new Node(-1);
        Node A = l1;
        Node B = l2;
        while (A != null && B != null) {
            if (A.value == B.value) {
                Node node = new Node(B.value);
                node.next = null;
                dummyHead.next = node;
                A = A.next;
                l2 = l2.next;
                B = l2;
            } else {
                if(B.next != null) {
                    B = B.next;
                }else {
                    A = A.next;
                    B = l2;
                }
            }
        }
        return dummyHead;
    }

}
