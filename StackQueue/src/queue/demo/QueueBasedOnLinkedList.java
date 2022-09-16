package queue.demo;

/**
 * @author zhaoqw
 * @date 2022/09/16
 */
public class QueueBasedOnLinkedList {
  private Node head = null;
  private Node tail = null;

  private static class Node{
    private String data;
    private Node next;

    public Node(String data, Node next) {
      this.data = data;
      this.next = next;
    }

    public String getData() {
      return data;
    }
  }
  // 入队
  public void enqueue(String value) {
    if (tail == null) {
      Node newNode = new Node(value, null);
      head = newNode;
      tail = newNode;
    } else {
      Node newNode = new Node(value, null);
      tail.next = newNode;
      tail = newNode;
    }
  }

  // 出队
  public String dequeue() {
    if (head == null) return null;

    String value = head.data;
    head = head.next;
    if (head == null) tail = null;
    return value;
  }

  public void printAll() {
    Node p = head;
    while (p != null) {
      System.out.print(p.data + "   ");
      p = p.next;
    }
    System.out.println();
  }
}
