package cn.zqwzhao.recursiontest01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 设计一个算法，利用一个整数栈将一个整数队列中的所有元素倒过来，对头变队尾，队尾变对头
 * @Auther: zhaoqw
 * @Date: 2021/6/19 - 06 - 19 - 19:55
 * @Description: cn.zqwzhao.recursiontest01
 * @version: 1.0
 */
public class StackQueueTest001 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.offer(11);
        queue.offer(22);
        queue.offer(33);
        queue.offer(44);
        queue.offer(55);
        while(!queue.isEmpty()) {
           stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }
}
