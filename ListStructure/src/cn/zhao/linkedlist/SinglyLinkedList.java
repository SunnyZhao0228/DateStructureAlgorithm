package cn.zhao.linkedlist;

/**
 * 单向非循环链表
 *
 * @author zhaoqw
 * @date 2022/06/10
 */
public class SinglyLinkedList {
  private Node head = null;


  public static class Node{
    private int data;
    private Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
    public int getData() {
      return data;
    }

    public void setData(int data) {
      this.data = data;
    }
  }

  public static Node createNode(int value) {
    return new Node(value, null);
  }


  public Node findByIndex(int index) {

    return null;
  }

  public Node findByValue(int value) {
    return null;
  }

  /**
   * 无头结点
   * 表头部插入
   * 这种操作将于输入的顺序相反，逆序
   * @param value 值
   */
  public void insertToHead(int value) {

  }

  public void insertToHead(Node newNode) {

  }

  //
  // 顺序插入
  //链表尾部插入
  public void insertTail(int value){

  }

}
