package org.example.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试
 *
 * @author zhaoqw
 * @date 2023/7/25
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        linkedList.forEach(integer -> System.out.print(integer + ' '));
        System.out.println();
        arrayList.forEach(integer -> System.out.print(integer + ' '));
        System.out.println();

    }
}
