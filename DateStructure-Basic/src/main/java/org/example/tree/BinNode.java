package org.example.tree;

/**
 * @author zhaoqw
 * @date 2023/8/21
 */
public interface BinNode<T> {
    T element();

    void setElement(T t);

    /**
     * 返回
     * @return
     */
    BinNode left();

    /**
     * 设置左孩子
     *
     * @return BinNode
     */
    BinNode setLeft(BinNode p);

    /**
     * 返回右孩子
     *
     * @return BinNode
     */
    BinNode right();

    /**
     * 设置右孩子
     *
     * @return BinNode
     */
    BinNode setRight(BinNode p);


    // 判断是否是叶子节点
    boolean isLeaf();

}
