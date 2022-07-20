package basic.exercise01;

/**
 * 数组实现队列
 *
 * @author zhaoqw
 * @date 2022/7/2
 */
public class Code03ArrayImplQueue {

  public static class ArrayQueue {
    private int[] arr;
    private int pushi;
    private int polli;
    private int size; //数组存储元素实际个数
    private final int limit;

    public ArrayQueue(int limit) {
      this.limit = limit;
      arr = new int[limit];
      pushi = 0;
      polli = 0;
      size = 0;
    }

    public void push(int value) {
      if (size == limit) {
        throw new RuntimeException("队列已满！不能再添加了！");
      }
      size++;
      arr[pushi] = value;
      pushi = nextIndex(pushi);
    }

    public int poll() {
      if (size == 0) {
        throw new RuntimeException("队列为空！");
      }
      size--;
      int ans = arr[polli];
      polli = nextIndex(polli)
      return ans;
    }

    public int nextIndex(int index) {
      return index < limit - 1 ? index + 1 : 0;
    }

    public boolean isEmpyt() {
      return size == 0;
    }
  }
}
