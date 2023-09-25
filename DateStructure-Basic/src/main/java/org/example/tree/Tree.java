package org.example.tree;

/**
 * @author zhaoqw
 * @date 2023/9/25
 */
public class Tree<T> {
    public BinNode<T>[] nodes;

    int root;

    int n;

    public Tree() {
    }

    public Tree(BinNode<T>[] nodes) {
        this.nodes = nodes;
    }

    public BinNode<T>[] getNodes() {
        return nodes;
    }

    public void setNodes(BinNode<T>[] nodes) {
        this.nodes = nodes;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
