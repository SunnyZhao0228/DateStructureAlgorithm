package org.example.queue;

/**
 * 动态数组队列
 *
 * @author zhaoqw
 * @date 2023/7/28
 */
public class DynamicArrayQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public DynamicArrayQueue(int capacity) {
        this.items = new String[capacity];
        n = capacity;
    }

    // 入队操作，将item放入队尾
    public boolean enqueue(String item) {
        if (tail == n) {
            // tail == n && head ==0 代表已经存满
            if (head == 0) return false;

            // 搬动数据
            for(int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail++] = item;
        return true;
    }

    // 出队
    public String dequeue() {
        if (head == tail) return null;
        String res = items[head];
        head++;
        return res;
    }

    public void printAll() {
        for (int i = head; i < tail; i ++) {
            System.out.print(items[i] + "  ");
        }
        System.out.println("");
    }
}
