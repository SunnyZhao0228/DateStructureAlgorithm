package org.example.tree;

/**
 * 二叉树基本实现
 *
 * @author zhaoqw
 * @date 2023/8/21
 */
public class BinNodePtr<T> implements BinNode<T> {
    // 节点数据对象
    private T element;

    // 左指针
    private BinNode left;

    // 右指针
    private BinNode right;

    public BinNodePtr() {
    }

    public BinNodePtr(T element) {
        this.right = null;
        this.left = null;
        this.element = element;
    }

    public BinNodePtr(T element, BinNode left, BinNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public void setElement(T t) {
        this.element = t;
    }

    @Override
    public BinNode left() {
        return left;
    }

    @Override
    public BinNode setLeft(BinNode binNode) {

        return null;
    }

    @Override
    public BinNode right() {
        return null;
    }

    @Override
    public BinNode setRight(BinNode binNode) {
        return null;
    }

    @Override
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }
}
