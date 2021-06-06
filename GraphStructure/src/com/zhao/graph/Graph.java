package com.zhao.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 图
 * @Auther: zhaoqw
 * @Date: 2021/6/2 - 06 - 02 - 20:39
 * @Description: com.zhao.graph
 * @version: 1.0
 */
public class Graph {
    public HashMap<Integer, Node> nodes; //保存节点
    public HashSet<Edge> edges; //保存边

    public Graph() {
       nodes = new HashMap<>();
       edges = new HashSet<>();
    }
}
