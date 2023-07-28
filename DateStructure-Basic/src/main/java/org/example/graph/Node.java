package org.example.graph;

import java.util.ArrayList;

/**
 * @author zhaoqw
 * @date 2023/7/28
 */
public class Node {
    /**
     * 存储的值, 再抽象的话这个值类型可以改成泛型
     */
    public int value;

    /**
     * 入度，别的点有多少指向它
     */
    public int in;

    /**
     *  出度，它有多少指向其他点的
     */
    public int out;

    //它指向的直接邻居
    public ArrayList<Node> nexts;

    //所在的边
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}