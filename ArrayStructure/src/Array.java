/**
 * 1. 实现数据插入，删除，数组按照下标随机访问
 * 2. 数组中的数据用int类型进行模拟
 *
 * @author: zhaoqw
 * @date: 2022/04/26 09:17
 */
public class Array {
  // 保存数据用的数组
  private int data[];
  // 数组长度
  private int n;
  // 数组中数据实际个数
  private int count;

  // 构造方法定义数组大小
  public Array(int capacity) {
    this.data = new int[capacity];
    this.n = capacity;
    this.count = 0;
  }

  //根据索引，找到数组中的元素并返回
  public int get(int index) {
    if (index < 0 || index >= count) {
      return -1;
    }
    return data[index];
  }

  //根据索引，修改数组中的元素并返回
  public int set(int index, int value) {
    if (index < 0 || index >= count) {
      return -1;
    }
    return data[index] = value;
  }

  //插入元素:头部插入，尾部插入,中间插入
  public boolean insert(int index, int value) {
    // 数组没有元素
    //if (index == count && count == 0) {
    //    data[index] = value;
    //    ++count;
    //    return true;
    //}

    // 数组已经满了
    if (count == n) {
      System.out.println("数组已满，There is no space to insert");
      return false;
    }
    // 位置判断
    if (index < 0 || index > count) {
      System.out.println("插入位置不合法，Index is illegal");
      return false;
    }

    for (int i = count - 1; i > index; --i) {
      data[i] = data[i - 1];
    }
    data[index] = value;
    ++count;
    return true;
  }


  //根据索引，删除数组中元素
  public boolean delete(int index) {
    //位置判断
    if (index < 0 || index >= count) {
      System.out.println("删除位置不合法，Index is illegal");
      return false;
    }

    for (int i = index; i < count - 1; i++) {
      data[index] = data[index + 1];
    }
    count --;
    return true;
  }

  public void printArray() {
    for (int i = 0; i < count; i++) {
      System.out.print(data[i] + "  ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
      Array array = new Array(10);
      array.insert(0,1);
      array.insert(1,2);
      array.insert(2,3);
      array.insert(3,4);
      array.insert(4,5);
      array.insert(5,6);
      array.insert(6,7);
      array.insert(7,8);
      array.printArray();
  }

}
