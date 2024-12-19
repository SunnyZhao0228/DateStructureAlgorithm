package org.example.array;

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
    }
}
