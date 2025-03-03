package org.example.binaryTree;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        left=right=null;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
