package org.example.tree;


import java.util.Scanner;

/**
 * [1,2,3,4,5,6,7,8,9,10]
 * 其中1为根节点
 * 后面遵循，2为左，3为右，4为左，5为右，轮训
 * 也就是  左2*i， 右2*i+1
 *
 * @author zhaoqw
 * @date 2023/8/21
 */
public class BtreeTest01 {
    public static void main(String[] args) {
        int index = 1;
        int data;
        BiTreeArray biTreeArray = new BiTreeArray();
        biTreeArray.initBiTreeArray();
        System.out.println("Please Input Btree element: ");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Data" + index +  ":");
            data = scanner.nextInt();
            biTreeArray.createBtree(data);
            index++;
        } while (data != 0);
        biTreeArray.printAll();
    }

}

class BiTreeArray {
    private static final int MAX_SIZE = 16;

    int[] bTree = new int[MAX_SIZE];

    public void initBiTreeArray() {
        for(int i = 0; i < MAX_SIZE; i++) {
            bTree[i] = 0;
        }
    }

    public void createBtree(int data) {
        int level = 1; // 树的层数为1层
        //是否存在子树1
        while(bTree[level] != 0) {
            // 判断是左子树还是右子树
            if (data < bTree[level]) {
                level = level * 2;
            } else {
                level = level * 2 + 1;
            }
        }
        bTree[level]  = data;
    }

    public void printAll() {
        System.out.println("Btree Nodes: ");
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.print("Node" + i );
            System.out.println("["  + bTree[i] + "]");
        }
    }
}
