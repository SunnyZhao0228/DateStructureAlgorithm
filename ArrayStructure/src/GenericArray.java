import java.util.HashMap;

/**
 * @author: zhaoqw
 * @date: 2022/05/05
 */
public class GenericArray<T> {
  /**
   * 数据
   */
  private T[] data;
  /**
   * 实际元素个数
   */
  private int size;

  public GenericArray(int size) {
    data = (T[]) new Object[size];
    this.size = 0;
  }

  // 无参构造方法，默认数组容量为10
  public GenericArray() {
    this(10);
  }

  // 获取当前元素个数
  public int count() {
    return this.size;
  }

  // 获取数组容量
  public int getCapacity() {
    return data.length;
  }

  // 判断数组是否为空
  public boolean isEmpty() {
    return size == 0;
  }

  // 修改 index 位置的元素
  public void set(int index, T e) {
    checkIndex(index);
    data[index] = e;
  }

  // 获取对应 index 位置的元素
  public T get(int index) {
    checkIndex(index);
    return data[index];
  }

  // 查看数组是否包含元素e
  public boolean contains(T e) {
    for (int i = 0; i < data.length; i++) {
      if (data[i].equals(e)) {
        return true;
      }
    }
    return false;
  }

  // 获取对应元素的下标, 未找到，返回 -1
  public int find(T e) {
    for (int i = 0; i < data.length; i++) {
      if (data[i].equals(e)) {
        return i;
      }
    }
    return -1;
  }
  // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
  public void insert(int index, T e) {
    checkIndex(index);

    // 容量不够，扩容
    if (data.length == size) {
      resize(2 * data.length);
    }

    //
    for (int i = size - 1; i >= index; i--) {
      data[i + 1] = data[i];
    }
    data[index] = e;
    ++this.size;
  }

  // 向数组头插入元素
  public void addFirst(T e) {
    insert(0, e);
  }

  // 向数组尾插入元素
  public void addLast(T e) {
    insert(size, e);
  }

  // 删除 index 位置的元素，并返回
  public T remove(int index) {
    checkIndex(index);
    new HashMap<>();
    return null;
  }
  // 删除第一个元素

  // 删除末尾元素


  // 扩容方法，时间复杂度 O(n)
  private void resize(int capacity) {
    T[] newData = (T[]) new Object[capacity];

    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }

  // check index
  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
    }
  }

  private void checkIndexForAdd(int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
    }
  }
}
