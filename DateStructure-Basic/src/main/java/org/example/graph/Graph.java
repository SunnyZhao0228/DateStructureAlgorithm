package org.example.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhaoqw
 * @date 2023/7/28
 */
public class Graph {
    public HashMap<Integer, Node> nodes; //保存节点
    public HashSet<Edge> edges; //保存边

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }


    public static void bfs(Node start) {
        if(start == null) {
            return ;
        }

        Queue<Node> queue = new LinkedList<>();
        //去重处理，
        HashSet<Node> set = new HashSet<>();

        //往队列里面添加节点
        queue.add(start);
        set.add(start);
        while(!queue.isEmpty()) {
            //出队列
            Node cur = queue.poll();
            System.out.println(cur.value);
            for(Node next: cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public static void dfs(Node node) {
        if (node == null) {
            return ;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        //入栈就打印
        System.out.println(node.value);
        while (! stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

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
                graph.nodes.put(to,new Node(to));
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
