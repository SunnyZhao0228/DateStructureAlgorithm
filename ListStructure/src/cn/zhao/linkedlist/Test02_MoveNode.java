package cn.zhao.linkedlist;

import java.util.LinkedList;

/**
 *
 * @Auther: zhaoqw
 * @Date: 2021/6/26 - 06 - 26 - 8:57
 * @Description: cn.zhao.linkedlist
 * @version: 1.0
 */
public class Test02_MoveNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    public static void main(String[] args) {

    }





    public void move(int[] array){
        int i = 0;
        int j = array.length-1;
        while(i < j){
            while(array[i]<0) i++; //从前往后找第一个>0的数
            while(array[j]>0) j--; //从后往前找第一个<0的数
            //找到就交换
            array[i] = array[i]^array[j];
            array[j] = array[i]^array[j];
            array[j] = array[i]^array[j];
            /**
             * int temp =  array[i];
             * array[i] = array[j];
             * array[j] = temp;
             */
        }
    }



}
