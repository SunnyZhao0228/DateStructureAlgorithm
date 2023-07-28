package org.example.queue;

/**
 *
 * 数组实现循环队列
 *
 * @author zhaoqw
 * @date 2023/7/28
 */
public class CircularQueue {
    private int[] arr;
    private int pushi; //end
    private int polli; //begin
    private int size;
    private final int limit;

    public CircularQueue(int limit) {
        this.limit = limit;
        this.pushi = 0;
        this.polli = 0;
        this.size = 0;
        this.arr = new int[limit];
    }


    // 入队
    public boolean enqueue(int item) {
        // 队列已满
        if (size == limit) return false;
        ++size;
        arr[pushi] = item;
        pushi = nextIndex(pushi);
        return true;
    }


    // 出队
    public int dequeue() {
        // 队列空
        if (size == 0) return -1;
        --size;
        int res = arr[polli];
        polli = nextIndex(polli);
        return res;
    }

    private int nextIndex(int index) {
        return index < limit - 1 ? index + 1 : 0;
    }

    public void printAll() {
        if (size == 0) return;
        for (int i = polli; i % arr.length != pushi; i = (i + 1) % arr.length) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(10);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        circularQueue.printAll();
    }
}
