package org.example.tree;

/**
 * 二叉树基本实现
 *
 * @author zhaoqw
 * @date 2023/8/21
 */
public class BinNode<T> {
    // 节点数据对象
    public T data;

    // 左指针
    public BinNode<T> left;

    // 右指针
    public BinNode<T> right;

    public BinNode() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    public BinNode(T data, BinNode<T> left, BinNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }


}
