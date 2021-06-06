package com.zhao.graph;

import java.util.HashSet;
import java.util.Stack;

/**
 * @Auther: zhaoqw
 * @Date: 2021/6/2 - 06 - 02 - 21:21
 * @Description: com.zhao.graph
 * @version: 1.0
 */
public class Graph_DFS {
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
}
