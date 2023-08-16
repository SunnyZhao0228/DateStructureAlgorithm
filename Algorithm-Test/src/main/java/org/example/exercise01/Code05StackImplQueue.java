package org.example.exercise01;

import java.util.Stack;

/**
 * 图的宽度优先遍历 队列实现
 * 图的深度优先遍历 栈实现
 *
 * 怎么用栈实现图的宽度优先遍历 -> 利用栈实现队列结构
 * @author zhaoqw
 * @date 2022/7/2
 */
public class Code05StackImplQueue {

    /**
     * push 栈
     * pop 栈
     *
     * push栈元素出栈 往pop栈中push
     * 取数据的时候，从pop栈中取
     * 注意：
     * 1. 需要一次性将push栈中元素全部导出到pop栈中
     * 2. 需要一次性取完
     */
    public static class TwoStackQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStackQueue() {
            stackPop = new Stack<Integer>();
            stackPush = new Stack<Integer>();
        }

        private void pushToPop() {
            if (stackPop.empty()) {
                while (! stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int value) {
            stackPush.push(value);
            pushToPop();
        }

        public int poll() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("Queue is Empty");
            }
            pushToPop();
            return stackPop.pop();
        }
        public int peek() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("Queue is Empty");
            }
            pushToPop();
            return stackPop.peek();
        }
    }


    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        for (int i = 0; i < 6; i++) {
            System.out.print(queue.poll() + " ");
        }
    }
}
