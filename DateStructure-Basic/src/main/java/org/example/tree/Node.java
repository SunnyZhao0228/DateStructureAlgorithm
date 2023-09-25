package org.example.tree;

/**
 * 二叉树基本实现
 *
 * @author zhaoqw
 * @date 2023/8/21
 */
public class Node<T> {
    // 节点数据对象
    public T data;

    // 左指针
    public Node<T> left;

    // 右指针
    public Node<T> right;

    public Node() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }


}
