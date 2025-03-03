package org.example.binaryTree;

public class TreeMain {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
      /*  tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(12);
        tree.add(18);
        tree.traverseInOrder(tree.root);
        System.out.println(tree.containsNode(4));
        System.out.println(tree.containsNode(7));*/

        int[] tree1values = {5, 3, 8, 4, 1, 2};
        int[] tree2values = {4, 1, 2};

        Node tree1 = tree.createTreeFromValues(tree1values);
        Node tree2 = tree.createTreeFromValues(tree2values);

        boolean result = tree.isSubtree(tree1, tree2);
        System.out.println("Czy tree2 jest poddrzewem tree1? : " + result);

    }
}
