package com.zhao.graph;

import java.util.ArrayList;

/**
 * 点结构的描述
 * @Auther: zhaoqw
 * @Date: 2021/6/2 - 06 - 02 - 20:31
 * @Description: com.zhao.graph
 * @version: 1.0
 */
public class Node {
    public int value; //存储的值
    public int in;    //入度，别的点有多少指向它
    public int out;   //出度，它有多少指向其他点的
    public ArrayList<Node> nexts;  //它指向的直接邻居
    public ArrayList<Edge> edges; //所在的边

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
