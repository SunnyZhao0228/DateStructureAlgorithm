package basic.exercise01;

/**
 * 用数组实现队列
 *
 * @author zhaoqw
 * @date 2022/7/2
 */
public class Code07RingArray {
    public static class MyQueue {
        private int[] arr;
        private int pushi; //end
        private int polli; //begin
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            this.limit = limit;
            this.size = 0;
            this.polli = 0;
            this.pushi  = 0;
            arr = new int[limit];
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列已满！不能再添加了！");
            }
            size ++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int poll() {
            if (size == 0) {
                throw  new RuntimeException("队列为空！");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private int nextIndex(int index) {
            return index < limit - 1 ? index + 1 : 0;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(10);
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
    }
}
