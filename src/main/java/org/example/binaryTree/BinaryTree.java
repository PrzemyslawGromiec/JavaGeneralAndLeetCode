package org.example.binaryTree;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if(current == null) {
            return new Node(value);
        }

        if(value < current.value) {
            current.left = addRecursive(current.left,value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root,value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public int calculateHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        return Math.max(leftHeight,rightHeight) + 1;
    }

    public boolean isSameTree(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;  // Oba drzewa są puste
        }
        if (root1 == null || root2 == null) {
            return false;  // Jedno z drzew jest puste, a drugie nie
        }
        if (root1.value != root2.value) {
            return false;  // Wartości bieżących węzłów się nie zgadzają
        }

        // Rekurencyjnie sprawdź lewy i prawy poddrzewo
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    public boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;  // Jeśli root jest null, nie może mieć poddrzewa
        }
        if (isSameTree(root, subRoot)) {
            return true;  // Jeśli bieżące drzewa są identyczne, znaleźliśmy poddrzewo
        }

        // Sprawdź lewe i prawe poddrzewo
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public Node createTreeFromValues(int[] values) {
        BinaryTree tree = new BinaryTree();
        for (int value : values) {
            tree.add(value);
        }
        return tree.root;
    }

}
