package cn.zhao.linkedlist;

/**
 * 单向非循环链表
 * 单链表的插入、删除、查找操作；
 * 链表中存储的是int类型的数据；
 *
 * @author zhaoqw
 * @date 2022/06/10
 */
public class SinglyLinkedList {
  private Node head = null;

  public static class Node {
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


  /**
   * 根据index查找链表中的元素
   * @param index 索引
   * @return
   */
  public Node findByIndex(int index) {
    Node p = head;
    int pos = 0;
    while(p != null && pos != index) {
      p = p.next;
      ++ pos;
    }
    return p;
  }

  public Node findByValue(int value) {
    Node p = head;
    while(p != null && p.data != value) {
        p = p.next;
    }
      return p;
  }

  /**
   * 无头结点
   * 表头部插入
   * 这种操作将于输入的顺序相反，逆序
   *
   * @param value 值
   */
  public void insertToHead(int value) {
    Node node = new Node(value, null);
    insertToHead(node);
  }

  // 无头节点
  public void insertToHead(Node newNode) {
    // 空链表，直接作为头
    if (head == null) {
      head = newNode;
    }else {
      newNode.next = head;
      head = newNode;
    }
  }

  //
  // 顺序插入
  //链表尾部插入
  public void insertTail(int value) {
    Node node = new Node(value, null);
    insertTail(node);
  }

  /**
   * 链表尾插入新节点
   *
   * @param newNode
   */
  public void insertTail(Node newNode) {
    if (head == null) {
      head = newNode;
    } else {
      Node p = head;
      while(p.next != null) {
        p = p.next;
      }
      newNode.next = p.next;
      p.next = newNode;
    }


  }

  /**
   * 再 p的后面插入节点
   *
   * @param p 节点p
   * @param value 节点的值
   */
  public void insertAfter(Node p, int value) {
    Node newNode = new Node(value, null);
    insertAfter(p, newNode);
  }

  /**
   * 在 p的后面插入新节点
   * @param p 节点p
   * @param newNode 新节点
   */
  public void insertAfter(Node p, Node newNode) {
    if (p == null) return;

    newNode.next = p.next;
    p.next = newNode;
  }

  /**
   * 在p节点之前插入新节点
   *
   * @param p 节点p
   * @param value 值
   */
  public void insertBefore(Node p, int value) {
    Node newNode = new Node(value, null);
    insertBefore(p, newNode);
  }

  /**
   * 在节点p之前插入新节点
   *
   * @param p 节点p
   * @param newNode 新节点
   */
  public void insertBefore(Node p, Node newNode) {
    if (p == null)  return;
    if (head == p) {
      insertToHead(newNode);
      return;
    }
    // 循环找到q前面的第一个节点
    Node q = head;
    while (q != null && q.next != p) {
      q = q.next;
    }
    if (q == null) return;
    newNode.next = q.next;
    q.next = newNode;
  }


  /**
   * 删除节点
   *
   * @param p 节点p
   */
  public void deleteByNode(Node p) {
    if (p == null || head == null) {
      return;
    }

    deleteByValue(p.getData());
  }

  public void deleteByValue(int value) {

  }

  public void printAll() {
  }

  //判断true or false
  public boolean TFResult(Node left, Node right) {
    return false;
  }

  //判断是否为回文
  public boolean palindrome() {
    return false;
  }

  //带结点的链表翻转
  public Node inverseLinkList_head(Node p) {

    return null;
  }

  //无头结点的链表翻转
  public Node inverseLinkList(Node p) {
    return null;
  }

  public static void main(String[] args) {
    SinglyLinkedList link = new SinglyLinkedList();
    System.out.println("hello");
    //int data[] = {1};
    //int data[] = {1,2};
    //int data[] = {1,2,3,1};
    //int data[] = {1,2,5};
    //int data[] = {1,2,2,1};
    // int data[] = {1,2,5,2,1};
    int data[] = {1,2,5,3,1};

    for(int i =0; i < data.length; i++){
      //link.insertToHead(data[i]);
      link.insertTail(data[i]);
    }
    // link.printAll();
    // Node p = link.inverseLinkList_head(link.head);
    // while(p != null){
    //     System.out.println("aa"+p.data);
    //     p = p.next;
    // }

    System.out.println("打印原始:");
    link.printAll();
    if (link.palindrome()){
      System.out.println("回文");
    }else{
      System.out.println("不是回文");
    }
  }
}
