package org.example.invertTree;

import org.example.binaryTree.Node;

public class InvertedTree {

    public static void invertTree(Node root) {
        if (root == null) {
            return;
        }
        invertTree(root.getLeft());
        invertTree(root.getRight());

        Node temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
    }

    public static void printPreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue() + " ");
        printPreOrder(root.getLeft());
        printPreOrder(root.getRight());
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));

        System.out.println("Tree before inversion:");
        printPreOrder(root);
        System.out.println();

        System.out.println("Tree after inversion:");
        invertTree(root);
        printPreOrder(root);
    }
}
