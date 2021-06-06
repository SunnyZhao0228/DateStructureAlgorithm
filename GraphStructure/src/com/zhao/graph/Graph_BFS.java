package com.zhao.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 宽度优先遍历
 * @Auther: zhaoqw
 * @Date: 2021/6/2 - 06 - 02 - 21:21
 * @Description: com.zhao.graph
 * @version: 1.0
 */
public class Graph_BFS {
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
}
