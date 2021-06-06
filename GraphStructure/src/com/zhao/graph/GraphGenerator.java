package com.zhao.graph;

import java.lang.reflect.GenericArrayType;

/**
 *
 * @Auther: zhaoqw
 * @Date: 2021/6/2 - 06 - 02 - 20:46
 * @Description: com.zhao.graph
 * @version: 1.0
 */
public class GraphGenerator {
    /**
     * matrix 所有的边
     * N*3 的矩阵
     * [weight,from节点上面的值，to节点上面的值]
     * [5,0,7]
     * [3,0,1]
     * 宽度5，0到7
     * 宽度3，0到1
     */

    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            //拿到每一条边
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];

            //图中不存在这个点，则put进去
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from,new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(from,new Node(to));
            }

            //拿到
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);

            Edge newNode = new Edge(weight,fromNode,toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newNode);
            graph.edges.add(newNode);
        }
        return graph;
    }

    public static void main(String[] args) {

    }

}

