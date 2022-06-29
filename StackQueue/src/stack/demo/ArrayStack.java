package stack.demo;

/**
 * @author zhaoqw
 * @date 2022/06/29
 */
public class ArrayStack {
  /**
   * 数组，用作栈空间
   */
  private String[] items;

  /**
   * 栈中元素个数
   */
  private int count;

  /**
   * 栈的大小
   */
  private int capacity;

  public ArrayStack(int capacity) {
    this.capacity = capacity;
    this.items = new String[capacity];
    this.count = 0;
  }
  // 入栈操作
  public boolean push(String item) {
    // 数组空间不够了直接返回false
    if (count == capacity) {
      return false;
    }
    // 将item放到下标为count的位置，并且count+1
    items[count] = item;
    ++count;
    return true;
  }
  // 出栈操作
  public String pop() {
    // 如果没有元素了，返回null
    if (count == 0) {
      return null;
    }
    String temp = items[count];
    --count;
    return temp;
  }

}
