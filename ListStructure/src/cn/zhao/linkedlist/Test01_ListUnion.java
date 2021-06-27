package cn.zhao.linkedlist;

import java.util.ArrayList;

/**
 * @Auther: zhaoqw
 * @Date: 2021/6/19 - 06 - 19 - 20:52
 * @Description: cn.zhao.linkedlist
 * @version: 1.0
 */
public class Test01_ListUnion {
    static class Node {
        Integer value;
        Node next;

        public Node(Integer value) {
            this.value = value;
            this.next = null;
        }

        public void addNode(Node post) {
            this.next = post;
        }

    }

    /**
     * 求LA LB 差集 （差集：属于LA不属于LB的集合），时间复杂度O（n^2） 空间O(1)
     * 总的思路就是两层Loop遍历LA，和LB, 找出LA中有的而LB没有的
     * @param LA
     * @param LB
     * @return LA
     */
    public static Node diff(Node LA, Node LB) {
        if (LA == null || LB == null) {
            return LA;
        }
        Node pA = LA;
        Node pB = LB;
        Node preNode = null;

        //遍历LA
        while (pA != null) {
            //如果pB.value != pA.value 继续遍历LB
            while (pB != null && pB.value != pA.value) {
                pB = pB.next;
            }
            // 遇到相同的节点，且pB不为空
            if (pB != null) {
                //LA的第一个节点需要删除，LA保存pA的下个节点
                if (preNode == null) {
                    LA = pA.next;
                } else { //非LA的首节点 （ 直接删除pA）
                    preNode.next = pA.next;
                }
                //更新新的pA
                pA = pA.next;
            } else {
                preNode = pA;
                pA = pA.next;
            }
            //pB初始化
            pB = LB;
        }
        return LA;
    }

    /**
     * 总的思路就是两层Loop遍历LA，和LB, 找出LA中有的而LB也有的
     * 时间O(n^2) 空间O(n)
     * @param LA
     * @param LB
     * @return
     */
    public static Node union(Node LA, Node LB) {
        if (LA == null || LB == null) {
            return LA;
        }
        Node pA = LA;
        Node pB = LB;
        Node head = new Node(-1);
        Node curr = head;
        //遍历LA
        while (pA != null) {
            //如果pB.value != pA.value 继续遍历LB
            while (pB != null && pB.value != pA.value) {
                pB = pB.next;
            }
            // 遇到相同的节点，且pB不为空
            if (pB != null) {
                Node newNode = new Node(pB.value);
                curr.addNode(newNode);
                curr = curr.next;
            }
            pA = pA.next;
            //pB初始化
            pB = LB;
        }
        return head.next;
    }

    public static void printList(Node head) {
        Node pNode = head;
        while (pNode != null) {
            System.out.print("[" + pNode.value + "]-->");
            if (pNode.next != null) {
                pNode = pNode.next;
            } else {
                System.out.println("NULL");
                return;
            }
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.addNode(node2);
        node2.addNode(node3);
        node3.addNode(node4);


        Node node5 = new Node(2);
        Node node6 = new Node(3);
        Node node7 = new Node(4);
        Node node8 = new Node(6);
        node5.addNode(node6);
        node6.addNode(node7);
        node7.addNode(node8);

        printList(node1);
        printList(node5);

        Node diff = diff(node1, node5);
//		Node newHead = change(node1);
//		printList(newHead);
        printList(diff);


//        LinkedList<Integer> l1 = new LinkedList<>();
//        l1.add(1);
//        l1.add(2);
//        l1.add(3);
//        l1.add(4);
//
//
//        LinkedList<Integer> l2 = new LinkedList<>();
//        l2.add(3);
//        l2.add(4);
//        l2.add(5);
//
//        System.out.println(l1);
//        l1.removeAll(l2);
//        System.out.println(l1);
    }

}
