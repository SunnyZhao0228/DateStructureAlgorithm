package org.example.queue;

/**
 * 数据实现队列
 */
public class ArrayQueue {
  // 数组：items，
  private String[] items;
  // 数组大小：n
  private int n = 0;
  // head 表示队头下标，tail 表示队尾下标
  private int head = 0;
  private int tail = 0;

  // 申请一个大小为 capacity 的数组
  public ArrayQueue(int capacity) {
    items = new String[capacity];
    n = capacity;
  }

  // 入队
  public boolean enqueue(String item) {
    // 队列已满
    if(tail == n) return false;
    items[tail++] = item;
    return true;
  }

  // 出队
  public String dequeue() {
    // 队列已空
    if (head == tail) return null;
    String res = items[head];
    ++head;
    return res;
  }
}