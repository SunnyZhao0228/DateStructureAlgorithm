package org.example.linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        
        // 测试 add 方法
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        System.out.println("After adding elements: " + list); // 输出: [size=3, null_1_2, 1_2_3, 2_3_null]
        
        // 测试 add 方法在头部插入元素
        list.add(0, 0);
        System.out.println("After adding element 0 at index 0: " + list); // 输出: [size=4, null_0_1, 0_1_2, 1_2_3, 2_3_null]
        
        // 测试 add 方法在中间插入元素
        list.add(2, 15);
        System.out.println("After adding element 15 at index 2: " + list); // 输出: [size=5, null_0_1, 0_1_15, 1_15_2, 15_2_3, 2_3_null]
        
        // 测试 get 方法
        System.out.println("Element at index 1: " + list.get(1)); // 输出: Element at index 1: 1
        
        // 测试 set 方法
        list.set(1, 20);
        System.out.println("After setting element at index 1 to 20: " + list); // 输出: [size=5, null_0_20, 0_20_15, 20_15_2, 15_2_3, 2_3_null]
        
        // 测试 remove 方法
        list.remove(1);
        System.out.println("After removing element at index 1: " + list); // 输出: [size=4, null_0_15, 0_15_2, 15_2_3, 2_3_null]
        
        // 测试 remove 方法在头部删除元素
        list.remove(0);
        System.out.println("After removing element at index 0: " + list); // 输出: [size=3, null_15_2, 15_2_3, 2_3_null]
        
        // 测试 remove 方法在尾部删除元素
        list.remove(2);
        System.out.println("After removing element at index 2: " + list); // 输出: [size=2, null_15_2, 15_2_null]
        
        // 测试 clear 方法
        list.clear();
        System.out.println("After clearing the list: " + list); // 输出: [size=0, ]
        
        // 测试 isEmpty 方法
        System.out.println("Is list empty after clearing? " + list.isEmpty()); // 输出: Is list empty after clearing? true
        
        // 测试 size 方法
        System.out.println("Size of list after clearing: " + list.size()); // 输出: Size of list after clearing: 0
        
        // 测试 indexOf 方法
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        System.out.println("Index of element 20: " + list.indexOf(20)); // 输出: Index of element 20: 1
        System.out.println("Index of element 40: " + list.indexOf(40)); // 输出: Index of element 40: -1
    }
}