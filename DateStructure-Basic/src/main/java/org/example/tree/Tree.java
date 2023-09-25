package org.example.tree;

/**
 * @author zhaoqw
 * @date 2023/9/25
 */
public class Tree<T> {
    public Node<T>[] nodes;

    int root;

    int n;

    public Tree() {
    }

    public Tree(Node<T>[] nodes) {
        this.nodes = nodes;
    }

    public Node<T>[] getNodes() {
        return nodes;
    }

    public void setNodes(Node<T>[] nodes) {
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
