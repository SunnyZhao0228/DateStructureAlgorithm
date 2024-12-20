package org.example.array;

import org.example.domain.Person;

import java.util.ArrayList;

/**
 * @author zhaoqw
 * @date 2024/12/19
 */
public class ArrayTest {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(1);
        integerMyArrayList.add(2);
        integerMyArrayList.add(3);
        integerMyArrayList.add(4);
        integerMyArrayList.add(5);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        System.out.println(integers);
        System.out.println(integerMyArrayList);
        integerMyArrayList.removeLast();
        System.out.println(integerMyArrayList);
        integerMyArrayList.remove(0);
        System.out.println(integerMyArrayList);
        integerMyArrayList.add(0, 100);
        integerMyArrayList.add(0, 200);
        System.out.println(integerMyArrayList);

        MyArrayList<Person> mList = new MyArrayList<Person>();

        mList.add(new Person(10, "jack"));
        mList.add(new Person(20, "rose"));
        mList.add(null);
        mList.add(null);

        System.out.println("add()添加元素: " + mList);

        System.out.println("get()获取元素: " + mList.get(0));

        mList.set(0, new Person(99, "ghost"));
        System.out.println("set()设置元素值: " + mList);

        mList.remove(0);
        System.out.println("remove()删除元素: " + mList);

        mList.clear();
        System.out.println("clear()清空数组: " + mList);
    }
}
