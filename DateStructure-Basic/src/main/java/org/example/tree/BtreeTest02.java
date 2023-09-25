package org.example.tree;

/**
 * @author zhaoqw
 * @date 2023/9/25
 */
public class BtreeTest02 {
    public static void main(String[] args) {

    }
}

class BtreeArray {
    private static final int MAX_SIZE = 16;

    int[] treeData = new int[MAX_SIZE];
    int[] rightNode = new int[MAX_SIZE];
    int[] leftNode = new int[MAX_SIZE];

    public BtreeArray() {
        for (int i = 0; i < MAX_SIZE; i++) {
            treeData[i] = 0;
            rightNode[i] = 0;
            leftNode[i] = 0;
        }
    }

}
