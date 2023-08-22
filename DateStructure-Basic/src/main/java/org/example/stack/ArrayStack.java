package org.example.stack;

/**
 * @author zhaoqw
 * @date 2023/8/21
 */
public class ArrayStack {
    private String[] items; // 数组
    private int count; // 元素个数
    private int n; // 栈的大小


    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    public boolean push(String item) {
        if (count == n) return false;
        items[count] = item;
        count++;
        return true;
    }

    public String pop() {
        if (count == 0) return null;
        return items[--count];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push("1");
        arrayStack.push("2");
        arrayStack.push("3");
        arrayStack.push("4");
        arrayStack.push("5");
        for (int i = 0; i < 5; i++) {
            System.out.println(arrayStack.pop());
        }
    }
}
