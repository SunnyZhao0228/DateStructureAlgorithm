package org.example.tree;

/**
 * @author zhaoqw
 * @date 2023/9/25
 */
public class BTreeIteration {
    public static void main(String[] args) {
        int[][] nodes = {
                {'a', 1, 2},
                {'b', 3, -1},
                {'c', 4, 5},
                {'d', 6, 7},
                {'e', -1, -1},
                {'f', 8, -1},
                {'g', -1, -1},
                {'h', -1, -1},
                {'i', -1, -1},
        };
        Tree<Integer> tree = new Tree<>(new Node[nodes.length]);
        intTree(nodes, tree);
        System.out.println("前序遍历: ");
        preOrder(tree.nodes[tree.root]);
        System.out.println();
        System.out.println("中序遍历: ");
        inOrder(tree.nodes[tree.root]);
        System.out.println();
        System.out.println("后序遍历: ");
        postOrder(tree.nodes[tree.root]);

    }


    public static void intTree(int[][] arr, Tree<Integer> tree) {
        for (int i = 0; i < arr.length; i++) {
            tree.nodes[i] = new Node<>(-1, null, null);
        }
        tree.n = arr.length;
        tree.root = 0;

        for (int i = 0; i < arr.length; i++) {
            tree.nodes[i].data = arr[i][0];
            tree.nodes[i].left = arr[i][1] == -1 ? null : tree.nodes[arr[i][1]];
            tree.nodes[i].right = arr[i][2] == -1 ? null : tree.nodes[arr[i][2]];
        }
    }

    static void printNode(Node<Integer> node) {
        System.out.print(node.data + "  ");
    }


    static void preOrder(Node<Integer> root) {
        if (root == null) {
            return ;
        }
        printNode(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node<Integer> root) {
        if (root == null) {
            return ;
        }
        preOrder(root.left);
        printNode(root);
        preOrder(root.right);
    }

    static void postOrder(Node<Integer> root) {
        if (root == null) {
            return ;
        }
        preOrder(root.left);
        preOrder(root.right);
        printNode(root);
    }
}
