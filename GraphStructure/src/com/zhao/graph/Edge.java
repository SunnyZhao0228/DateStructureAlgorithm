package com.zhao.graph;

/**
 * 边的定义
 * @Auther: zhaoqw
 * @Date: 2021/6/2 - 06 - 02 - 20:36
 * @Description: com.zhao.graph
 * @version: 1.0
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
