package stack.demo;

/**
 * 链表实现栈
 *
 * @author zhaoqw
 * @date 2022/09/16
 */
public class StackBasedOnLinkedList {
  private Node top = null;

  private static class Node {
    private int data;
    private Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

    public int getData() {
      return data;
    }
  }

  public void push(int value) {
    Node node = new Node(value, null);
    if (top == null) top = node;
    else {
      node.next = top;
      top = node;
    }
  }


  public int pop() {
    if (top == null) return -1;
    int res = top.data;
    top = top.next;
    return res;
  }

  public void printAll() {
    Node p = top;
    if (top == null) return ;
    while(p != null) {
      System.out.print(p.data + "   ");
      p = p.next;
    }
    System.out.println(" ");
  }
}
